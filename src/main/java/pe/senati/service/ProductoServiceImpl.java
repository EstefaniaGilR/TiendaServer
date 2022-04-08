package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Producto;
import pe.senati.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService
{
	@Autowired
	private ProductoRepository repository;

	@Override
	@Transactional
	public void insert(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional
	public void update(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional
	public void delete(Integer productoId) {
		repository.deleteById(productoId);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer productoId) {
		return repository.findById(productoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_withProveedor(){
		return repository.findAll_withProveedor();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_withProveedorText(){
		return repository.findAll_withProveedorText();
	}
}
