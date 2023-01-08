package modelo;

public class Orden {
    private String codigoCliente, fechaServicio, placa;
    private TipoVehiculo tipoVehiculo;
    private TipoTecnico tipoTecnico;
    
    public Orden(String codigoCliente, String fechaServicio, String placa, TipoVehiculo tipoVehiculo){
        this.codigoCliente = codigoCliente;
        this.fechaServicio = fechaServicio;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
  
}

