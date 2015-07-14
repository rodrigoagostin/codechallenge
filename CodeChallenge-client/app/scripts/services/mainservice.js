'use strict';

/**
 * @ngdoc service
 * @name codeChallengeClientApp.mainService
 * @description
 * # mainService
 * Service in the codeChallengeClientApp.
 */
angular.module('codeChallengeClientApp')
  .service('mainService', function (Restangular) {

  	var service = Restangular.all('coupons');

    return {
    	postOne: function(cpf) {
    		return service.one('user_coupon').post(cpf);
    	}
    };
  });
