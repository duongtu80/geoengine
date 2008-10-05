from django.db import models
import xml.etree.ElementTree as ET
import urllib
import datetime

class serviceUrl(models.Model):
	url = models.URLField('URL')
	version = models.CharField('Version', max_length=10, default='0.4.0')
	service = models.CharField('Service', max_length=10, default='WPS')

	class Admin:
		fields = ((None, {'fields': ('url',)}), ('Service Information', {'fields': ('service', 'version'), 'classes': 'collapse'}))
		search_fields = ['service', 'verison', 'url']
	
	def __unicode__(self):
		return self.url
	
	def save(self, raw=False):
		models.Model.save(self, raw)
		self.parseService(self.url, self.service, self.version)

	def parseService(self, url, service, version):
		_url = url
		if not _url.endswith('?'):
			_url += '?'

		_params = urllib.urlencode({'request': 'GetCapabilities', 'service': service, 'version': version})
		_f = urllib.urlopen((_url + '%s') % _params) 

		_txt = _f.read()
		_dom = ET.XML(_txt)

		if not _dom:
			raise NotFoundServiceError(_url)
			
		_tree = ET.ElementTree(_dom)
		
		_purl = _url
		
		for _p in _tree.findall('//{http://www.opengeospatial.net/ows}Operation'):
			if _p.get('name') == 'DescribeProcess':
				_desc = (ET.ElementTree(_p)).find('//{http://www.opengeospatial.net/ows}Get')
				print _desc.keys()
				_purl = _desc.get('{http://www.w3.org/1999/xlink}href')
				print 'new url', _purl
				if not _purl.endswith('?'):
					_purl += '?'
			
				break
		
		_s = serviceMetadata()
		_s.createDate = datetime.datetime.now()
		_s.metadata = _txt
		_s.url = self
		_s.save()

		for _e in _tree.findall('//{http://www.opengeospatial.net/wps}Process'):
			_process = ET.ElementTree(_e)
			
			_pid = _process.find('{http://www.opengeospatial.net/ows}Identifier')
			_title= _process.find('{http://www.opengeospatial.net/ows}Title')
			_abstract = _process.find('{http://www.opengeospatial.net/ows}Abstract')
			
			self.parsePrcess(_s, _purl, service, version, _pid)
		
			
	def parsePrcess(self, s, url, service, version, identifier):
		_url = url
		if not _url.endswith('?'):
			_url += '?'

		_params = urllib.urlencode({'request': 'DescribeProcess', 'service': service, 'version': version, 'Identifier': identifier.text})
		_url = (_url + '%s') % _params
		
		print _url
		_f = urllib.urlopen(_url) 

		_txt = _f.read()
		_dom = ET.XML(_txt)
		
		_p = processMetadata()
		_p.metadata = _txt
		_p.service = s
		_p.save()

	class NotFoundServiceError(StandardError):
		def __init__(self, url):
			self.url = url

class serviceMetadata(models.Model):
	createDate = models.DateTimeField('created date')
	metadata = models.TextField('metadata')
	url = models.ForeignKey(serviceUrl)
	
	class Admin:
		search_fields = ['createDate', 'metadata']
		
	def __unicode__(self):
		if self.metadata:
			return (ET.ElementTree(ET.XML(self.metadata))).find('{http://www.opengeospatial.net/ows}ServiceIdentification/{http://www.opengeospatial.net/ows}Title').text
		else:
			return 'no metadata'

class processMetadata(models.Model):
	metadata = models.TextField('metadata')
	service = models.ForeignKey(serviceMetadata)

	class Admin:
		search_fields = ['metadata']

	def __unicode__(self):
		if self.metadata:
			return (ET.ElementTree(ET.XML(self.metadata))).find('{http://www.opengeospatial.net/wps}ProcessDescription/{http://www.opengeospatial.net/ows}Title').text
		else:
			return 'no metadata'

