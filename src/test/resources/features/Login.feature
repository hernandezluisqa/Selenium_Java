Feature: Inicio de sesion
  @LoginSuccess
  Scenario: Usuario inicia sesion exitosamente
    Given el usuario está en la página principal "https://demoqa.com/books"
    And hace clic en el botón de login
    When ingresa el usuario "Curso2024" y la contraseña "diciembreUpex_24$"
    And hace clic en el botón de login del formulario
    Then debería ser redirigido al perfil del usuario

