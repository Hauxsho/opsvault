package com.dev.OpsVault.models.response.caseService.caseDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class CaseResponse
{
	List<CaseDetail> caseDetailList;
}