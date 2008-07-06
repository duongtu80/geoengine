Install

Download and install JRE 1.6.

Open your computer system properties window, and go to the "Advanced" tab, click "Environmental Variables", add a new variable with new "JRE_HOME" value [you JRE install path].


Configure file:

The file is located here:
D:\modelService\geoengine\webapps\wetland\WEB-INF\applicationContext.xml

You may open it using Windows Notepad:

1) If you changed your IP address, you should replace "127.0.0.1" with your IP address;

2) If you move the service folder (the modelService folder, please do not change the inner folder structure of it) to another directory, you should replace the path "D:\modelservice" to you new path, such as "d:\xxx\xxx\modelService";

After modify the configure file, please restart the geoengine server.

One more thing: Please make sure there is a "d:\temp" folder on your computer;




Start server:

There are 2 servers need to be started. run:

D:\modelService\geoengine\bin\startup.bat
D:\modelService\wetland\bin\startup.bat



Visit service:

go to http://[ip address]:8080/wetland/map.do

