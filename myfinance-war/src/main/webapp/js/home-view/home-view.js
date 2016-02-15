'use strict';

angular.module('myFinanceApp.homeView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'js/home-view/home-view.html',
    controller: 'homeViewCtrl'
  });
}])

.controller('homeViewCtrl', [function() {

}]);