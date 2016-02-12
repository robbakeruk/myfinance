angular.module('myFinanceApp').

factory('transactionService', function ($resource) {

   var data = $resource('http://localhost:8080/myfinance/rest/transactions/:id', {id: "@id"}, {
   update:{
       method:'PUT'
       }
   });
   return data;
});