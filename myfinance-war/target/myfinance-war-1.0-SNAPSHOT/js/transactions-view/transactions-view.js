'use strict';

angular.module('myFinanceApp.transactionsView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/transactions', {
    templateUrl: 'transactions-view/transactions-view.html',
    controller: 'TransactionsViewCtrl'
  });
}])

.controller('TransactionsViewCtrl', [function() {

}]);