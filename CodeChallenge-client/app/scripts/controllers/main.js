'use strict';

/**
 * @ngdoc function
 * @name codeChallengeClientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the codeChallengeClientApp
 */
angular.module('codeChallengeClientApp')
  .controller('MainCtrl', function ($scope, mainService) {

  	var service = mainService;
  	$scope.item = {};
    
  	$scope.send = function() {
  		$scope.hasError = false;
  		if ($scope.cpf === undefined) {
  			$scope.hasError = true;
  			return;
  		}
  		$scope.button = !$scope.button;
  		service.postOne($scope.cpf).then(function(result) {
  			if (result === undefined) {
  				$scope.cpfExists = true;
  			} else {
  				$scope.item = result;
  				$scope.success = true;
  			}
  			
  		});
  	};

});
