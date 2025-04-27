package com.dev.OpsVault.services.impl;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.OpsVault.models.response.caseService.caseDetails.CaseDetail;
import com.dev.OpsVault.models.response.caseService.caseDetails.CaseResponse;
import com.dev.OpsVault.services.contract.CaseService;

@Service
@AllArgsConstructor
public class CaseServiceImpl implements CaseService
{
	@Override
	public CaseResponse getListOfCases()
	{
		List<CaseDetail> caseDetailList = new ArrayList<>();
		caseDetailList.add(CaseDetail.builder()
		                             .caseCode("A123456")
		                             .caseId("1")
		                             .caseName("TestCase")
		                             .build());

		CaseResponse.builder().caseDetailList(caseDetailList).build();
		return null;
	}
}
