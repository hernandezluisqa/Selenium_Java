Feature: Ocultar y Mostrar Saldos
  @ocultar_saldos
  Scenario Outline: El usuario puede ocultar y mostrar los saldos de sus cuentas
    Given El usuario ha iniciado sesión en su cuenta bancaria satisfactoriamente
    And El usuario se encuentra en la pagina de Panel Principal
    When El usuario selecciona el icono Ocultar Saldos de la cuenta "<cuenta>"
    Then El saldo de la "<cuenta>" del usuario se oculta en la interfaz
    Examples:
      | cuenta             |
      | Cuenta Corriente   |
      | Caja de Ahorro     |
      | Tarjeta de Crédito |