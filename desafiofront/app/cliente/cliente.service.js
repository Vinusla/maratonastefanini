(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .service('clienteService', clienteService);

    clienteService.$inject = ['$http', 'constantes', 'helperFactory'];

    function clienteService($http, constantes, helper) {

        return {
            listar: listar,
            cadastrar: cadastrar
        }

        // ======================================

        function listar() {
            return $http.get(constantes.URL_BASE + '/cliente')
                .then(function (response) {                    
                    return response.data;
                })
                .catch(helper.sendError);
        }

        function cadastrar(_param) {
            console.log(_param);
            return $http.post(constantes.URL_BASE + '/cliente', _param)
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

    }


})();