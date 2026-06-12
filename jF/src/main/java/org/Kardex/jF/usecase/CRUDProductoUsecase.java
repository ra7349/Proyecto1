package org.Kardex.jF.usecase;

import java.util.List;

import org.Kardex.jF.bean.entity.Producto;

public interface CRUDProductoUsecase {
	public boolean insertar(Producto p);

	public List<Producto> listar();

	public boolean actualizar(Producto c);

	public boolean eliminar(Integer id);

	public Producto buscarPorCodigo(String codigo);

}
