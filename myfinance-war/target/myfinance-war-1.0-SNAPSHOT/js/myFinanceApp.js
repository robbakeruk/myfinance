"use strict";

var app = angular.module("myFinanceApp", [
    'ngResource',
    'ngRoute',
    'myFinanceApp.homeView',
    'myFinanceApp.transactionsView',
    'myFinanceApp.summaryView'
]);

app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.otherwise({redirectTo: '/home'});
}]);

