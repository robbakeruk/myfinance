angular.module('myFinanceApp').

factory('summaryService', function ($resource) {

  return $resource('http://localhost:8080/myfinance/rest/summary/:id', {id: "@id"});
});