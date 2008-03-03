from django.conf.urls.defaults import *

urlpatterns = patterns('',
	# Example:
	# (r'^metadata/', include('metadata.foo.urls')),

	#Uncomment this for admin:
	(r'^admin/', include('django.contrib.admin.urls')),
	(r'^polls/$', 'metadata.models.views.index'),
	(r'^polls/(?P<poll_id>\d+)/$', 'metadata.models.views.detail'),
#	(r'^polls/(?P<poll_id>\d+)/results/$', 'metadata.models.views.results'),
#	(r'^polls/(?P<poll_id>\d+)/vote/$', 'metadata.models.views.vote'),
)
