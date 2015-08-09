'use strict';

var rnatest = {};

var App = angular.module('rnatest', ['ngRoute', 'ui.grid', 'ui.grid.pagination', 'ui.grid.autoResize',  'rnatest.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/upload', {
        templateUrl: 'uploadlayout',
        controller: UploadController
    });

    $routeProvider.when('/download', {
        templateUrl: 'downloadlayout',
        controller: DownloadController
    });
    
    $routeProvider.when('/list', {
        templateUrl: 'listlayout',
        controller: ListController
    });

    $routeProvider.otherwise({redirectTo: '/upload'});
}]);
