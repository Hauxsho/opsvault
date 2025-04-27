package com.dev.OpsVault.models.response.caseService.caseDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class CaseDetail
{
	String caseId;
	String caseCode;
	String caseName;
}
