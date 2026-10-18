public class AdministracionGerencia {
    public static void main(String[] args) {
        Gerencia gerencia = new Gerencia("Los Arroyos");

        // Cabaña: 5 días con 3 habitaciones. Base: $120. (Costo = $600 + $30x5x3 = $1050)
        Cabaña cabaña = new Cabaña("Cabañas La Alondra", 120.0, 5, 3);
        cabaña.agregarServicio(new Servicio("alquiler auto", 100.0));
        cabaña.agregarServicio(new Servicio("lavanderia", 20.0));

        // Hotel: 1 semana (7 días) Single. Base: $70. (Costo = $490 + $20x7 = $630)
        Hotel hotel = new Hotel("Hotel Guarani", 70.0, 7, "Single");
        hotel.agregarServicio(new Servicio("internet", 5.0));
        hotel.agregarServicio(new Servicio("alquiler auto", 100.0));

        gerencia.agregarAlojamiento(cabaña);
        gerencia.agregarAlojamiento(hotel);

        gerencia.mostrarLiquidacion();
    }
}