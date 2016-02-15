'use strict';

angular.module('myFinanceApp.summaryView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/summary', {
    templateUrl: 'js/summary-view/summary-view.html',
    controller: 'summaryViewCtrl'
  });
}])

.controller('summaryViewCtrl', ['$scope',
    function($scope) {

}]);