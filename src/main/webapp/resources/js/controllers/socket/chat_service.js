App.service('ChatService',['$timeout','$q',function($timeout,$q){
	var self =this ;
	var listener = $q.defer();
	var socket = {
	      client: null,
	      stomp: null
	    };
	var messageIds = [];
	 
	self.RECONNECT_TIMEOUT = 30000;
	self.SOCKET_URL = "/chat";
	self.CHAT_TOPIC = "/topic/message";
	self.CHAT_BROKER = "/app/chat";
	
	self.receive = function() {
	        return listener.promise;
	};
	      
	self.send = function(message) {

        var id = Math.floor(Math.random() * 1000000);
        //var idSender =Math.floor(Math.random() * 1000000);
        //var idReceiver=Math.floor(Math.random() * 1000000);
        socket.stomp.send(self.CHAT_BROKER, {
          priority: 9
        }, JSON.stringify({
            message: message.message,
	        idSender:message.idSender,
	        idReceiver:message.idReceiver,
	        nameSender:message.nameSender,
	        nameReceiver:message.nameReceiver,
            id: id
        }));
        messageIds.push(id);
      };
      
      var reconnect = function() {
        $timeout(function() {
          initialize();
        }, self.RECONNECT_TIMEOUT);
      };
      
      var getMessage = function(data) {
        var message = JSON.parse(data), out = {};
        out.message = message.message;
        out.idReceiver=message.idReceiver;
        out.idSender=message.idSender;
        out.nameReceiver=message.nameReceiver;
        out.nameSender=message.nameSender;
        out.time = new Date(message.time);
        if (_.contains(messageIds, message.id)) {
          out.self = true;
          messageIds = _.remove(messageIds, message.id);
        }
        return out;
      };
      
      var startListener = function() {
          socket.stomp.subscribe(self.CHAT_TOPIC, function(data) {
          listener.notify(getMessage(data.body));
        });
      };
      
      var initialize = function() {
        socket.client = new SockJS(self.SOCKET_URL);
        socket.stomp = Stomp.over(socket.client);
        socket.stomp.connect({}, startListener);
        socket.stomp.onclose = reconnect;
      };
      initialize();
      
}]);