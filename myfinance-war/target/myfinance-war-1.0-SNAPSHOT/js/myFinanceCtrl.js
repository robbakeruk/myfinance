

angular.module('myFinanceApp').

controller("myFinanceCtrl", [ '$scope', '$resource', 'transactionService', 'summaryService',
    function($scope, $resource, transactionService, summaryService) {
        //
        // GET Action Method
        //
        //var transactions = $resource('http://localhost:8080/myfinance/rest/transactions/:id', {id: "@id"});
        transactionService.query({}, function(allTransactions){
            $scope.transactions = allTransactions;
        });

        var categories = $resource('http://localhost:8080/myfinance/rest/reference-data/categories');
        categories.query({}, function(c){
            $scope.categories = c;
        });

        //var summaryRows = $resource('http://localhost:8080/myfinance/rest/summary');
//        summaryService.query({}, function(s){
//            $scope.summaryRows = s;
//        });

        var summaryDates = $resource('http://localhost:8080/myfinance/rest/summary/dates');
        summaryDates.get({}, function(d){
            $scope.summaryDates = d;
        });

        $scope.myDataSource = {
            chart: {
                caption: "Harry's SuperMart",
                subCaption: "Top 5 stores in last month by revenue",
            },
            data:[{
                label: "Bakersfield Central",
                value: "880000"
            },
            {
                label: "Garden Groove harbour",
                value: "730000"
            },
            {
                label: "Los Angeles Topanga",
                value: "590000"
            },
            {
                label: "Compton-Rancho Dom",
                value: "520000"
            },
            {
                label: "Daly City Serramonte",
                value: "330000"
            }]
            };

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

            $id = transaction.id;
            transactionService.update({ id:$id }, transaction);
        };

        $scope.selectedDateChanged = function() {

            var date = $scope.selectedDate;

            summaryService.query({id: date}, function(s){
                $scope.summaryRows = s;
            });
        };
    } ]);