'use strict';

angular.module('myFinanceApp.summaryView')

.directive('myCustomer', function() {
  return {
    restrict: 'E',
    templateUrl: 'my-customer.html'
  };
});