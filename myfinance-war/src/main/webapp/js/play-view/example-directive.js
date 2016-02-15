'use strict';

angular.module('myFinanceApp.playView')

.controller('playCtrl', ['$scope',
    function($scope) {

        $scope.incrementOneWay = function() {

            $scope.playOneWay = parseInt($scope.playOneWay) + 1;
        };

        $scope.incrementTwoWay = function() {

            $scope.playTwoWay.playId = parseInt($scope.playTwoWay.playId) + 1;
        };

    }])


.directive('example', function () {
     return {
         restrict: 'E',
         scope: {
             playOneWay: '@',
             playTwoWay: '='
             // @: 1-way binding, =: 2-way binding\ &: function e.g. event handler
         },
         templateUrl: 'js/play-view/example-directive.html',
         controller: 'playCtrl',
         link: function ($scope, element, attrs) {
//             element.bind('click', function () {
//                 element.html('You clicked me!');
//             });
//             element.bind('mouseenter', function () {
//                element.addClass('example-mouseenter');
//                //element.css('background-color', 'yellow');
//             });
//             element.bind('mouseleave', function () {
//                 //element.css('background-color', 'red');
//                 element.removeClass('example-mouseenter');
//             });
         }
     };
 });