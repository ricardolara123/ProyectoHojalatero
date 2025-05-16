package Main;

import java.util.Scanner;

import Dominio.Llantas;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lectura = null;

		long codigoBarra;
		String marca;
		String medidas;
		float precio;
		int existencia, menuPrin;

		Llantas llanta;

		LogicaMetodos imp = new LogicaMetodos();

		do {
			System.out.println(" MENÚ LLANTAS");
			System.out.println("1.----Alta");
			System.out.println("2.----Mostrar");
			System.out.println("3.----Buscar");
			System.out.println("4.----Editar");
			System.out.println("5.----Eliminar");
			System.out.println("6. Salir");

			lectura = new Scanner(System.in);
			menuPrin = lectura.nextInt();

			switch (menuPrin) {
			case 1:
				try {
					System.out.println("Ingrese el codigo de barra");
					lectura = new Scanner(System.in);
					codigoBarra = lectura.nextLong();

					System.out.println("Ingrese la marca");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();

					System.out.println("Ingrese las medidas ");
					lectura = new Scanner(System.in);
					medidas = lectura.nextLine();

					System.out.println("Ingrese el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Ingrese la existencia");
					lectura = new Scanner(System.in);
					existencia = lectura.nextInt();

					// crear objeto

					llanta = new Llantas(codigoBarra, marca, medidas, precio, existencia);

					// Agregar el hashMap
					imp.guardar(llanta);
					System.out.println("Se agrego");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar " + e.getMessage());
				}

				break;

			case 2:
				try {
					imp.mostrar();

				} catch (Exception e) {
					// TODO: handle exception

					System.out.println("Error al mostar " + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Ingrese el codigo de barra para buscar");
					lectura = new Scanner(System.in);
					codigoBarra = lectura.nextLong();

					// Buscar

					llanta = imp.buscar(codigoBarra);

					if (llanta != null)
						System.out.println("Se encontro " + llanta);
					else
						System.out.println("No existe ese registro");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No existe registro");
				}
				break;
			case 4:
				try {
					System.out.println("Ingrese el codigo de barra para editar");
					lectura = new Scanner(System.in);
					codigoBarra = lectura.nextLong();

					// Buscar

					llanta = imp.buscar(codigoBarra);

					if (llanta != null) {
						System.out.println("Se encontro " + llanta);

						// Actualizacion

						System.err.println("Ingrese la nueva marca");
						lectura = new Scanner(System.in);
						marca = lectura.nextLine();

						// Actualizacion del objeto
						llanta.setMarca(marca);

						// Actualizacion hashMap
						imp.editar(llanta);
						System.out.println("Se edito con exito");

					} else
						System.out.println("No existe ese registro");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No existe registro");
				}
				break;

			case 5:
				try {
					System.out.println("Ingrese el código de barra para eliminar");
					lectura = new Scanner(System.in);
					codigoBarra = lectura.nextLong();
					
					
                    //Eliminar
					imp.eliminar(codigoBarra);
					System.out.println("Se eliminó correctamente.");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al eliminar");
				}
				break;
			case 6:
				System.out.println("Gracias por usar el sistema");
				break;
			}

		} while (menuPrin < 6);

	}

}
