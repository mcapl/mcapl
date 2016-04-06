never { /* !(<>bag1holdblock && <>!bag2holdflag)  */
accept_init:
	if
	:: (bag2holdflag) -> goto accept_S2
	:: (!bag1holdblock) -> goto accept_S1
	fi;
accept_S1:
	if
	:: (!bag1holdblock) -> goto accept_S1
	fi;
accept_S2:
	if
	:: (bag2holdflag) -> goto accept_S2
	fi;
}
