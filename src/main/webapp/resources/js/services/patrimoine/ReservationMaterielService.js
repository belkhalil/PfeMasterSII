/**
 * 
 */
'use strict';
App.factory('ReservationMService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneReservationM: function(id){
    	    	return $http.get("/ReservationMateriel/getOneReservationMateriel/"+id)
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
    	    
            fetchAllReservationsM: function() {
                    return $http.get("/ReservationMateriel/reservationMateriels")
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
            
            createReservationM: function(reservation){
                    return $http.post("/ReservationMateriel/saveReservationMateriel", reservation)
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
                    return $http.put("/ReservationMateriel/updateReservationMateriel/"+id, reservation)
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
             
            deleteReservationM: function(id){
                    return $http.delete("/ReservationMateriel/deleteReservationMateriel/"+id)
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
            
            addMaterielToReservation : function(idM,idR){
             	 return $http.post("/ReservationMateriel/addMaterielToReservation/"+"?idm="+idM+"&idr="+idR)
             	 		.then(function(response){		
          				return response.data ;
          			},
          			function(errResponse){
          				console.error('Error while adding materiel  to reservation (service)');
                       return $q.reject(errResponse);
          			});
                }, 
                
               addUserToReservation : function(idU,idR){
                	 return $http.post("/ReservationMateriel/addUserToReservation/"+"?idu="+idU+"&idr="+idR)
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