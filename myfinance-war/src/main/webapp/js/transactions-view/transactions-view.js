'use strict';

angular.module('myFinanceApp.transactionsView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/transactions', {
    templateUrl: 'js/transactions-view/transactions-view.html',
    controller: 'transactionsViewCtrl'
  });
}])

.controller('transactionsViewCtrl', ['$scope', '$resource', 'transactionService',

    function($scope, $resource, transactionService) {
        transactionService.query({}, function(allTransactions){
            $scope.transactions = allTransactions;
        });

        var categories = $resource('http://localhost:8080/myfinance/rest/reference-data/categories');
        categories.query({}, function(c){
            $scope.categories = c;
        });

        $scope.isTransactionTagged = function(transaction) {

            if (transaction.categoryId > 0)
                return true;

            return false;
        };

        $scope.isTransactionUntagged = function(transaction) {

            if (transaction.categoryId > 0)
                return false;

            return true;
        };

        $scope.tagTransaction = function(transaction, category) {

            transaction.categoryId = category.id;

            var $id = transaction.id;
            transactionService.update({ id:$id }, transaction);
        };
}]);