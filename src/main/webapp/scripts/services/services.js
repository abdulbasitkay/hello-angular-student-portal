'use strict';

var services = angular.module('studentApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/rest';

services.factory('StudentListFactory', function ($resource) {
    return $resource(baseUrl + '/students', {}, {
        query: {method: 'GET', isArray: true},
        create: {method: 'POST'}
    });
});

services.factory('StudentFactory', function ($resource) {
    return $resource(baseUrl + '/students/:id', {}, {
        show: {method: 'GET'},
        update: {method: 'PUT', params: {id: '@id'}},
        delete: {method: 'DELETE', params: {id: '@id'}}
    });
});