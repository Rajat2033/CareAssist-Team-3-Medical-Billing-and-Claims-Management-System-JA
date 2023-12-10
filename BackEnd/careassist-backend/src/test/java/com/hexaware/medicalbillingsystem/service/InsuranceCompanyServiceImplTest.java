package com.hexaware.medicalbillingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.hexaware.medicalbillingsystem.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystem.repository.InsuranceCompanyRepository;
/*
@Author : Rajat Darvhekar 
Modified Date : 18-11-2023
Description : ServiceImpTest class for the InsuranceCompany
*/
class InsuranceCompanyServiceImplTest {

	@Mock
	InsuranceCompanyRepository companyRepositoryMock;

	@Autowired
	InsuranceCompanyRepository companyRepository;

	@Mock
	private PasswordEncoder passwordEncoderMock;

	@MockBean
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	InsuranceCompanyServiceImpl companyService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddCompany() {

		InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
		InsuranceCompany company = new InsuranceCompany();
		company.setCompanyId(companyDTO.getCompanyId());
		company.setCompanyName(companyDTO.getCompanyName());
		company.setCompanyContact(companyDTO.getCompanyContact());
		company.setCompanyEmail(companyDTO.getCompanyEmail());
		company.setCompanyStartYears(companyDTO.getCompanyStartYears());
		company.setCompanyPassword(companyDTO.getCompanyPassword());

		when(passwordEncoderMock.encode(companyDTO.getCompanyPassword())).thenReturn("encodedPassword");
		when(companyRepositoryMock.save(any(InsuranceCompany.class))).thenReturn(company);

		InsuranceCompany createdCompany = companyService.addCompany(companyDTO);

		verify(passwordEncoderMock).encode(companyDTO.getCompanyPassword());
		verify(companyRepositoryMock).save(any(InsuranceCompany.class));

		assertEquals(company.getCompanyId(), createdCompany.getCompanyId());
		assertEquals(company.getCompanyName(), createdCompany.getCompanyName());
		assertEquals(company.getCompanyContact(), createdCompany.getCompanyContact());
		assertEquals(company.getCompanyEmail(), createdCompany.getCompanyEmail());
		assertEquals(company.getCompanyPassword(), createdCompany.getCompanyPassword());
		assertEquals(company.getCompanyStartYears(), createdCompany.getCompanyStartYears());
		assertEquals(company.getRole(), createdCompany.getRole());

	}

	@Test
	void testUpdateCompany() {
		InsuranceCompanyDTO comapanyDTO = new InsuranceCompanyDTO();
		InsuranceCompany company = new InsuranceCompany();
		comapanyDTO.setCompanyId(company.getCompanyId());
		companyService.updateCompany(comapanyDTO,company.getCompanyId());
	}

	@Test
	void testDeleteCompanyById() {
		InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
		int companyId;
		companyId = companyDTO.getCompanyId();

		companyService.deleteCompanyById(companyId);
		verify(companyRepositoryMock, times(1)).deleteById(companyId);
	}

	@Test
	void testGetCompanyByName() {

		InsuranceCompany existingCompany = new InsuranceCompany();
		existingCompany.setCompanyId(existingCompany.getCompanyId());
		existingCompany.setCompanyName(existingCompany.getCompanyName());
		existingCompany.setCompanyPassword(existingCompany.getCompanyPassword());
		existingCompany.setCompanyContact(existingCompany.getCompanyContact());
		existingCompany.setCompanyEmail(existingCompany.getCompanyEmail());
		existingCompany.setCompanyStartYears(existingCompany.getCompanyStartYears());

		when(companyRepositoryMock.findByCompanyName(existingCompany.getCompanyName()))
				.thenReturn(Optional.of(existingCompany));
		InsuranceCompanyDTO companyDTO = companyService.getCompanyByName(existingCompany.getCompanyName());
		verify(companyRepositoryMock).findByCompanyName(existingCompany.getCompanyName());
		assertEquals(existingCompany.getCompanyName(), companyDTO.getCompanyName());

	}

	@Test
	void testGetAllInsuranceCompanyDetails() {
		companyService.getAllInsuranceCompanyDetails();
		verify(companyRepositoryMock).findAll();
	}

}
