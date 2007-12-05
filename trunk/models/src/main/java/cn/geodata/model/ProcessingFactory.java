package cn.geodata.model;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionsDocument;

import org.geotools.factory.Factory;

/**
 * Process factory, provide metadata and create instance
 * @author Fengm
 *
 */
public abstract class ProcessingFactory implements Factory {
	private static Logger log = Logger.getAnonymousLogger();
	protected ProcessDescriptionType metadata;	

	public ProcessingFactory() {
		try {
			this.metadata = ProcessDescriptionsDocument.Factory.parse(this.getMetadataStream()).getProcessDescriptions().getProcessDescriptionArray(0);
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}
	
	public abstract String getIdentifier();
	public abstract String getTitle();
	public abstract String getDescription();
	public abstract InputStream getMetadataStream() throws Exception;

	public ProcessDescriptionType getMetadata(){
		return this.metadata;
	}
	
	public abstract GeoProcessing createProcessing(Map<String, String> params) throws Exception;

    /**
     * Param class
     */
    class Param {
        final public boolean required;
        final public String key;
        final public Class type;
        final public String description;
        final public Object sample;

        public Param(String key) {
            this(key, String.class, null);
        }

        public Param(String key, Class type) {
            this(key, type, null);
        }

        public Param(String key, Class type, String description) {
            this(key, type, description, true);
        }

        public Param(String key, Class type, String description, boolean required) {
            this(key, type, description, required, null);
        }

        public Param(String key, Class type, String description, boolean required, Object sample) {
            this.key = key;
            this.type = type;
            this.description = description;
            this.required = required;
            this.sample = sample;
        }

        public Object lookUp(Map<String, Object> map) throws Exception {
            if (!map.containsKey(key)) {
                if (required) {
                    throw new IOException(key + "is required:" + description);
                } else {
                    return null;
                }
            }

            Object value = map.get(key);

            if (value == null) {
                return null;
            }

            if (value instanceof String && (type != String.class)) {
                value = handle((String) value);
            }

            if (value == null) {
                return null;
            }

            if (!type.isInstance(value)) {
                throw new IOException(key + " is type of " + type.getName() + " not " + value.getClass().getName());
            }

            return value;
        }

        public Object handle(String text) throws Exception {
            if (text == null) {
                return null;
            }

            if (type == String.class) {
                return text;
            }

            if (text.length() == 0) {
                return null;
            }

            // Parse array
            if (type.isArray()) {
                StringTokenizer tokenizer = new StringTokenizer(text, " ");
                List result = new ArrayList();

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    Object element;

                    try {
                        if (type.getComponentType() == String.class) {
                            element = token;
                        } else {
                            element = parse(token);
                        }
                    } catch (IOException ioException) {
                        throw ioException;
                    } catch (Throwable throwable) {
                        throw new Exception("Failed to create '" + text + "' from '" + type.getName() , throwable);
                    }

                    result.add(element);
                }

                Object array = Array.newInstance(type.getComponentType(), result.size());

                for (int i = 0; i < result.size(); i++) {
                    Array.set(array, i, result.get(i));
                }

                return array;
            }

            try {
                return parse(text);
            } catch (IOException ioException) {
                throw ioException;
            } catch (Throwable throwable) {
                throw new Exception("Failed to create '" + text + "' from '" + type.getName() , throwable);
            }
        }

        /**
         * Parse text
         * @param text
         * @return
         * @throws Throwable
         */
        public Object parse(String text) throws Throwable {
            Constructor constructor;

            try {
                constructor = type.getConstructor(new Class[] { String.class });
            } catch (SecurityException e) {
                //  type( String ) constructor is not public
                throw new IOException("Could not create " + type.getName() + " from text");
            } catch (NoSuchMethodException e) {
                // No type( String ) constructor
                throw new IOException("Could not create " + type.getName() + " from text");
            }

            try {
                return constructor.newInstance(new Object[] { text, });
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new Exception("Could not create " + type.getName() + ": from '"
                    + text + "'", illegalArgumentException);
            } catch (InstantiationException instantiaionException) {
                throw new Exception("Could not create " + type.getName() + ": from '"
                    + text + "'", instantiaionException);
            } catch (IllegalAccessException illegalAccessException) {
                throw new Exception("Could not create " + type.getName() + ": from '"
                    + text + "'", illegalAccessException);
            } catch (InvocationTargetException targetException) {
                throw targetException.getCause();
            }
        }

        /* 
         * Create array
         * @see java.lang.Object#toString()
         */
        public String toString() {
            StringBuffer buf = new StringBuffer();
            buf.append(key);
            buf.append('=');
            buf.append(type.getName());
            buf.append(' ');

            if (required) {
                buf.append("REQUIRED ");
            }

            buf.append(description);

            return buf.toString();
        }
    }
}
