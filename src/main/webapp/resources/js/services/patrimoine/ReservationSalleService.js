/**
 * 
 */
'use strict';
App.factory('ReservationService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneReservation: function(id){
    	    	return $http.get("/ReservationSalle/getOneReservationSalle/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching reservation');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
           /*
			 * fetchAllReservations: function() { return
			 * $http.get("/ReservationSalle/reservationSalles") .then(
			 * function(response){ return response.data; },
			 * function(errResponse){ console.error('Error while fetching
			 * reservation'); return $q.reject(errResponse); } ); },
			 */
    	    fetchAllReservations: function() {
                return $http.get("/ReservationSalle/resSalles")
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while fetching reservation');
                                    return $q.reject(errResponse);
                                }
                        );
        },
        
            createReservation: function(reservation){
                    return $http.post("/ReservationSalle/saveReservationSalle", reservation)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating reservation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateReservation: function(reservation, id){
                    return $http.put("/ReservationSalle/updateReservationSalle/"+id, reservation)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating reservation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteReservation: function(id){
                    return $http.delete("/ReservationSalle/deleteReservationSalle/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting reservation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            addSalleToReservation : function(idS,idR){
             	 return $http.post("/ReservationSalle/addSalleToReservation/"+"?ids="+idS+"&idr="+idR)
             	 		.then(function(response){		
          				return response.data ;
          			},
          			function(errResponse){
          				console.error('Error while adding salle  to reservation (service)');
                       return $q.reject(errResponse);
          			});
                }, 
                
                addUserToReservation : function(idU,idR){
                	 return $http.post("/ReservationSalle/addUserToReservation/"+"?idu="+idU+"&idr="+idR)
                	 		.then(function(response){		
             				return response.data ;
             			},
             			function(errResponse){
             				console.error('Error while adding user  to reservation (service)');
                          return $q.reject(errResponse);
             			});
                   }, 
         
    
             

    };
 }]);