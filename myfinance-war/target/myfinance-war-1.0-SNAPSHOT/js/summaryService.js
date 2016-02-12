angular.module('myFinanceApp').

factory('summaryService', function ($resource) {

      var data = $resource('http://localhost:8080/myfinance/rest/summary/:id', {id: "@id"}, {
      update:{
          method:'PUT'
          }
      });
      return data;
  });