'use strict';

angular.module('myFinanceApp.playView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/play', {
    templateUrl: 'js/play-view/play-view.html',
    controller: 'playViewCtrl'
  });
}])

.controller('playViewCtrl', ['$scope',
    function($scope) {

        $scope.test = {
            playId: 12345
        };
}]);