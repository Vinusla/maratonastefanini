(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('ClientesController', clientesController);

    clientesController.$inject = ['helperFactory', 'clienteService'];

    function clientesController(helper, service) {
        var vm = this;

        vm.go = helper.go;
        vm.iniciar = iniciar;

        function iniciar() {            
            return vm.listarClientes();
        }

        vm.listarClientes = listarClientes;

        function listarClientes() {
            return service.listar()
                .then(function (_listaClientes) {
                    vm.listarClientes = _listaClientes;
                    helper.rootScopeApply();
                });
        }
    }
        

})();