function ProgressQueue() {
	this.main = null;
	this.queue = [];
//		this.messagePanel = dojo.byId('progressPanel');
	this.messageDiv = null;
	this.current = null;
	
	this.init = function(main) {
		this.main = main;
	};
	
//	this.pushProgress = function(p){
//		if(this.queue.length > 0){
//			Ext.Msg.alert('Busy...');
//			return;
//		}
//		
//		this.pushProcess(p, null, null, null);
//	};
//	
	this.pushTask = function(title, url, params, obj, fun){
		this.queue.push({'title': title, 'url': url, 'params': params, 'obj': obj, 'fun': fun});
		this.processQueue();		
	};
	
	this.processQueue = function() {
		if(this.current == null && this.queue.length > 0){
			var _p = this.queue.pop();
			this.processProcess(_p);
		}
	};
	
	this.processProcess = function(p){
		this.current = p;

		this.main.utils.wait(p.title);
		Ext.Ajax.request( {
			url : p.url,
			params : p.params,
			scope : this,
			success : function(result, request) {
				if (this.main.utils.processException(result, true)){
					this.popProgress();
					return;
				}
				
				this.current.fun.apply(this.current.obj, [result]);
				this.popProgress();
			},
			failure : function(result, request) {
				this.popProgress();
			}
		});
	};
	
	this.popProgress = function(){
		this.current = null;
		this.main.utils.unwait();

		this.processQueue();
	};
}
