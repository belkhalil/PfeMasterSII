App.service('MainModelService',['$timeout','$q','$http',function($timeout,$q,$http){
	var self =this ;
	self.users={};
	self.message='';
	self.logedUserId='';
	self.chat_boxs=[];
	
	var listener = $q.defer();
	var socket = {
		      client: null,
		      stomp: null
		    };
	
	self.RECONNECT_TIMEOUT = 30000;
	self.SOCKET_URL = "/chat";
	self.CHAT_TOPIC = "/topic/users/";

	self.getMessage= function(){
		return self.message;
	};
	self.setMessage =function(newMessage){
		self.message =newMessage ;
	};
	
	//	
	var reconnect = function() {
    $timeout(function() {
        initialize();
      }, this.RECONNECT_TIMEOUT);
    };
	
	 var getMessage = function(data) {
	        var users = JSON.parse(data);
	        var out = {};
	        out.users = users;
	        return out;
	      };
	     
		 var startListener = function() {
	         socket.stomp.subscribe(self.CHAT_TOPIC, function(data) {
	         listener.notify(getMessage(data.body));
	       });
	     };
     
	    self.receive = function() {
		        return listener.promise;
		};
		var initialize = function() {
	        socket.client = new SockJS(self.SOCKET_URL);
	        socket.stomp = Stomp.over(socket.client);
	        socket.stomp.connect({}, startListener);
	        socket.stomp.onclose = reconnect;
	      };
	   initialize();
	   
	   
//	   
	   self.initChatBoxes=function(){
	        
       	var chat_box ={
       		id:0,
       		actif :false,
       		messages:[],
       		messageToSend:'',
       		nameCender:'',
       		nameReciver:'',
       		idCender:null,
       		isNew : true,
       		idReciver:null,
       	};
       	var new_chat_box = angular.copy(chat_box);
       	new_chat_box.actif=false ;
       	self.chat_boxs.push(new_chat_box);
       	
       	var new_chat_box2 = angular.copy(chat_box);
       	new_chat_box2.id=1;
       	new_chat_box2.actif=false ;
       	self.chat_boxs.push(new_chat_box2);
       	
       	var new_chat_box3 = angular.copy(chat_box);
       	new_chat_box3.id=2;
       	new_chat_box2.actif=false ;
       	self.chat_boxs.push(new_chat_box3);
       	console.log("hi there "+self.chat_boxs);
       	
       };
       self.initChatBoxes();
	   
}]);