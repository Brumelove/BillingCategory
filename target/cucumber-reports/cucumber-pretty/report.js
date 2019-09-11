$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/features/whoisFunctional");
formatter.feature({
  "name": "Functional test",
  "description": "  As a tester\n  I want to aggregate for all resource type of member org-hdl\n  By calculating ipv4 allocation range",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Aggregation",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "All resources of ORG-HDL with Billing Category should be within range",
  "rows": [
    {
      "cells": [
        "ORG-HDL",
        "Billing Category"
      ]
    },
    {
      "cells": [
        "ORG-EISL2-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-IS33-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-UOCL1-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-GdId1-AFRINIC",
        "LIR very small"
      ]
    },
    {
      "cells": [
        "ORG-sCTL1-AFRINIC",
        "LIR very small"
      ]
    },
    {
      "cells": [
        "ORG-AoL2-AFRINIC",
        "LIR very small"
      ]
    },
    {
      "cells": [
        "ORG-ECN1-AFRINIC",
        "LIR small"
      ]
    },
    {
      "cells": [
        "ORG-AILC1-AFRINIC",
        "LIR small"
      ]
    },
    {
      "cells": [
        "ORG-AA21-AFRINIC",
        "LIR small"
      ]
    },
    {
      "cells": [
        "ORG-vm1-AFRINIC",
        "LIR medium"
      ]
    },
    {
      "cells": [
        "ORG-Au2-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-CKL1-AFRINIC",
        "LIR large"
      ]
    },
    {
      "cells": [
        "ORG-TA39-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-APTc1-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-Al8-AFRINIC",
        "LIR extra small"
      ]
    },
    {
      "cells": [
        "ORG-AM2-AFRINIC",
        "LIR small"
      ]
    },
    {
      "cells": [
        "ORG-VNL1-AFRINIC",
        "LIR very large"
      ]
    },
    {
      "cells": [
        "ORG-CIL1-AFRINIC",
        "LIR extra large"
      ]
    },
    {
      "cells": [
        "ORG-EA20-AFRINIC",
        "LIR large"
      ]
    },
    {
      "cells": [
        "ORG-EM1-AFRINIC",
        "LIR extra large"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.all_resources_should_be_within_range_for_with_category(DataTable)"
});
formatter.result({
  "status": "passed"
});
});