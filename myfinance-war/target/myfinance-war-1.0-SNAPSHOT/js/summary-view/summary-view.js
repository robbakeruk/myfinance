'use strict';

angular.module('myFinanceApp.summaryView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/summary', {
    templateUrl: 'js/summary-view/summary-view.html',
    controller: 'SummaryViewCtrl'
  });
}])

.controller('SummaryViewCtrl', ['$scope', '$resource', 'summaryService',
    function($scope, $resource, summaryService) {

        var summaryDates = $resource('http://localhost:8080/myfinance/rest/summary/dates');

        (function init() {
            // load data, init scope, etc.
            summaryDates.get({}, function(d){
                $scope.summaryDates = d;
            });
        })();

        $scope.selectedDateChanged = function() {

            var date = $scope.selectedDate;

            summaryService.query({id: date}, function(s){
                $scope.summaryRows = s;
            });
        };

    }]);