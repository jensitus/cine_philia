var myApp = angular.module('myApp',[]);


myApp.controller('MovieController', ['$scope', function($scope, $http) {
    movieController = {};

    movieController.loadMovie = function (id, $scope, $http) {
        $http.get('http://localhost:8081/rest/movies/' + $scope.movieId).
            success(function(data) {
                $scope.movie = data;
            });
    }
}]);

