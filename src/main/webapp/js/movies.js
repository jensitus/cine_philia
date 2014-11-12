var myApp = angular.module('myApp',['ngRoute', 'ngResource']);

myApp.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'pages/main.html' })
        .when('/movies', {
            templateUrl: 'pages/movies.html',
            controller: 'MoviesCtrl'})
        .when('/theaters', {
            templateUrl: 'pages/theaters.html'
        })
        .when('/theaters/:id', {
            templateUrl: 'pages/theater.html'
        })
        .when('/movie/:id', {
            templateUrl: 'pages/movie.html'
        })
        .when('/common', {
            templateUrl: 'pages/common.html' })
        .when('/search', {
            templateUrl: '/pages/search_form.html'
        })
        .otherwise({ redirectTo: '/'})
});

myApp.controller('SearchCtrl', ['$scope', '$http', '$location', function($scope, $http, $location) {
    //movieController = {};
    $scope.movieId = {};
    $scope.show_movie = {};
    $scope.loadMovie = function(id) {
        $scope.movieId = id;
        $http({
            url: 'http://localhost:8081/cine/rest/movies/' + id,
            method: 'GET'
        }).success(function(data){
            $scope.show_movie = data;
        })

    };

}]);

myApp.controller('MoviesCtrl', ['$scope', '$http', function($scope, $http) {
    $http.get('http://localhost:8081/cine/rest/movies/movielist').then(function(movList) {
        $scope.movieList = movList.data;
    })
}]);

myApp.controller('MovieCtrl', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
    $http.get('http://localhost:8081/cine/rest/movies/' + $routeParams.id).then(function(movie) {
        $scope.show_movie = movie.data;
    })
}]);

myApp.controller('TheatersCtrl', function($scope, $http) {
    $http.get('http://localhost:8081/cine/rest/theaters/theater_list').then(function(theaters) {
        $scope.theaterList = theaters.data;
    })
})

myApp.controller('TheaterCtrl', function($scope, $http, $routeParams) {
    $http.get('http://localhost:8081/cine/rest/theaters/' + $routeParams.id).then(function(theater) {
        $scope.show_theater = theater.data;
    })
})




