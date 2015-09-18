var app = angular.module('studentApp.controllers', []);

// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
        if (typeof(current) !== 'undefined'){
            $templateCache.remove(current.templateUrl);
        }
    });
});

app.controller('StudentListController', ['$scope', 'StudentListFactory', 'StudentFactory', '$location',
    function ($scope, StudentListFactory, StudentFactory, $location) {

        /* callback for ng-click 'editStudent': */
        $scope.editStudent = function (studentId) {
            $location.path('/update/' + studentId);
        };

        /* callback for ng-click 'deleteStudent': */
        $scope.deleteStudent = function (studentId) {
            StudentFactory.delete({id: studentId}).$promise.then(function () {
                $scope.students = StudentListFactory.query();
            });
        };

    }]);

app.controller('UpdateStudentController', ['$scope', '$routeParams', 'StudentFactory', '$location',
    function ($scope, $routeParams, StudentFactory, $location) {

        /* callback for ng-click 'updateStudent': */
        $scope.updateStudent = function () {
            StudentFactory.update($scope.student);
            $location.path('/create');
        };

        /* callback for ng-click 'cancel': */
        $scope.cancelUpdate = function () {
            $location.path('/create');
        };

        $scope.student = StudentFactory.show({id: $routeParams.id});
    }]);

app.controller('StudentCreationController', ['$scope', 'StudentListFactory', '$location',
    function ($scope, StudentListFactory, $location) {

        /* callback for ng-click 'createNewStudent': */
        $scope.createNewStudent = function () {
            StudentListFactory.create($scope.student).$promise.then(function () {
                $scope.students = StudentListFactory.query();
                $location.path('/create');
            });
        };

        $scope.students = StudentListFactory.query();
    }]);