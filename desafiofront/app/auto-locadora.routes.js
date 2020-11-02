(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .config(routes)
        .run(configDefaults);

    routes.$inject = ['$routeProvider'];
    configDefaults.$inject = ['$rootScope'];

    function routes($routeProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: 'home.tpl.html',
            })
            .when('/clientes', {
                templateUrl: 'cliente/clientes.tpl.html',
            })
            .when('/clientes/new', {
                templateUrl: 'cliente/register/cliente-register.tpl.html',
            })
            .otherwise({
                redirectTo: '/home'
            });
    }

    function configDefaults($rootScope) {
        $rootScope.listaMensagens = [];
    }

})();