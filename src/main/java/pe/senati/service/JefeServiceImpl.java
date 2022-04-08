package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Jefe;
import pe.senati.repository.JefeRepository;
@Service
public class JefeServiceImpl implements JefeService
{
	@Autowired
	private JefeRepository repository;

	@Override
	@Transactional
	public void insert(Jefe jefe) {
		repository.save(jefe);
		
	}

	@Override
	@Transactional
	public void update(Jefe jefe) {
		repository.save(jefe);
		
	}

	@Override
	@Transactional
	public void delete(Integer jefeId) {
		repository.deleteById(jefeId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Jefe findById(Integer jefeId) {
		return repository.findById(jefeId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Jefe> findAll() {
		return repository.findAll();
	}

}
