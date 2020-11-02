(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('ClienteRegisterController', clienteController);

    clienteController.$inject = ['clienteService', 'helperFactory'];

    function clienteController(service, helper) {
        var vm = this;

        vm.cadastrar = cadastrar;

        function cadastrar() {            
            return service.cadastrar(vm.cliente)
            .then(function (response) {
               if(!response.error){
                helper.path('/clientes');                
               }
            });;

        }
    }
        

})();