bool bag1holdblock

active proctype JPFModel()
{
state0:
	bag1holdblock = true;
	if
	:: goto state1;
	:: goto state37;
	fi;
state1:
	bag1holdblock = true;
	if
	:: goto state2;
	:: goto state24;
	fi;
end_state2:
	bag1holdblock = false;
	printf("end state\n");
state2:
	bag1holdblock = true;
	if
	:: goto state3;
	:: goto state15;
	fi;
end_state3:
	bag1holdblock = false;
	printf("end state\n");
state3:
	bag1holdblock = true;
	if
	:: goto state4;
	:: goto state10;
	fi;
end_state4:
	bag1holdblock = false;
	printf("end state\n");
state4:
	bag1holdblock = true;
	if
	:: goto state5;
	:: goto state9;
	fi;
end_state5:
	bag1holdblock = false;
	printf("end state\n");
state5:
	bag1holdblock = true;
	if
	:: goto state6;
	:: goto state8;
	fi;
end_state6:
	bag1holdblock = false;
	printf("end state\n");
state6:
	bag1holdblock = false;
	goto end_state2;
end_state7:
	bag1holdblock = false;
	printf("end state\n");
end_state8:
	bag1holdblock = false;
	printf("end state\n");
state8:
	bag1holdblock = false;
	goto end_state3;
end_state9:
	bag1holdblock = false;
	printf("end state\n");
state9:
	bag1holdblock = true;
	if
	:: goto state6;
	:: goto state8;
	fi;
end_state10:
	bag1holdblock = false;
	printf("end state\n");
state10:
	bag1holdblock = true;
	if
	:: goto state11;
	:: goto state14;
	fi;
end_state11:
	bag1holdblock = false;
	printf("end state\n");
state11:
	bag1holdblock = true;
	if
	:: goto state12;
	:: goto state13;
	fi;
end_state12:
	bag1holdblock = false;
	printf("end state\n");
state12:
	bag1holdblock = false;
	goto end_state4;
end_state13:
	bag1holdblock = false;
	printf("end state\n");
state13:
	bag1holdblock = false;
	goto end_state5;
end_state14:
	bag1holdblock = false;
	printf("end state\n");
state14:
	bag1holdblock = true;
	if
	:: goto state12;
	:: goto state13;
	fi;
end_state15:
	bag1holdblock = false;
	printf("end state\n");
state15:
	bag1holdblock = true;
	if
	:: goto state16;
	:: goto state21;
	fi;
end_state16:
	bag1holdblock = false;
	printf("end state\n");
state16:
	bag1holdblock = true;
	if
	:: goto state17;
	:: goto state20;
	fi;
end_state17:
	bag1holdblock = false;
	printf("end state\n");
state17:
	bag1holdblock = true;
	if
	:: goto state18;
	:: goto state19;
	fi;
state18:
	bag1holdblock = false;
	goto end_state6;
state19:
	bag1holdblock = false;
	goto end_state7;
state20:
	bag1holdblock = true;
	if
	:: goto state18;
	:: goto state19;
	fi;
state21:
	bag1holdblock = true;
	if
	:: goto state22;
	:: goto state23;
	fi;
state22:
	bag1holdblock = false;
	goto end_state8;
state23:
	bag1holdblock = false;
	goto end_state9;
state24:
	bag1holdblock = true;
	if
	:: goto state25;
	:: goto state31;
	fi;
state25:
	bag1holdblock = true;
	if
	:: goto state26;
	:: goto state29;
	fi;
state26:
	bag1holdblock = true;
	if
	:: goto state27;
	:: goto state28;
	fi;
state27:
	bag1holdblock = true;
	if
	:: goto state6;
	:: goto state8;
	fi;
state28:
	bag1holdblock = true;
	if
	:: goto state12;
	:: goto state13;
	fi;
state29:
	bag1holdblock = true;
	if
	:: goto state22;
	:: goto state30;
	fi;
state30:
	bag1holdblock = true;
	if
	:: goto state18;
	:: goto state19;
	fi;
state31:
	bag1holdblock = false;
	if
	:: goto state32;
	:: goto state35;
	fi;
state32:
	bag1holdblock = false;
	if
	:: goto state33;
	:: goto state34;
	fi;
state33:
	bag1holdblock = false;
	if
	:: goto state6;
	:: goto state8;
	fi;
state34:
	bag1holdblock = false;
	if
	:: goto state12;
	:: goto state13;
	fi;
state35:
	bag1holdblock = false;
	if
	:: goto state36;
	:: goto state23;
	fi;
state36:
	bag1holdblock = false;
	if
	:: goto state18;
	:: goto state19;
	fi;
state37:
	bag1holdblock = true;
	if
	:: goto state67;
	:: goto state38;
	fi;
state38:
	bag1holdblock = true;
	if
	:: goto state39;
	:: goto state60;
	fi;
state39:
	bag1holdblock = true;
	if
	:: goto state53;
	:: goto state40;
	fi;
state40:
	bag1holdblock = true;
	if
	:: goto state48;
	:: goto state41;
	fi;
state41:
	bag1holdblock = true;
	if
	:: goto state42;
	:: goto state45;
	fi;
state42:
	bag1holdblock = true;
	if
	:: goto state43;
	:: goto state44;
	fi;
state43:
	bag1holdblock = false;
	goto end_state10;
state44:
	bag1holdblock = false;
	goto end_state11;
state45:
	bag1holdblock = true;
	if
	:: goto state46;
	:: goto state47;
	fi;
state46:
	bag1holdblock = false;
	goto end_state12;
state47:
	bag1holdblock = false;
	goto end_state13;
state48:
	bag1holdblock = true;
	if
	:: goto state49;
	:: goto state52;
	fi;
state49:
	bag1holdblock = true;
	if
	:: goto state50;
	:: goto state51;
	fi;
state50:
	bag1holdblock = false;
	goto end_state14;
state51:
	bag1holdblock = false;
	goto end_state15;
state52:
	bag1holdblock = false;
	goto end_state16;
state53:
	bag1holdblock = false;
	if
	:: goto state54;
	:: goto state57;
	fi;
state54:
	bag1holdblock = false;
	if
	:: goto state55;
	:: goto state56;
	fi;
state55:
	bag1holdblock = false;
	if
	:: goto state43;
	:: goto state44;
	fi;
state56:
	bag1holdblock = false;
	if
	:: goto state46;
	:: goto state47;
	fi;
state57:
	bag1holdblock = false;
	if
	:: goto state58;
	:: goto state59;
	fi;
state58:
	bag1holdblock = false;
	if
	:: goto state50;
	:: goto state51;
	fi;
state59:
	bag1holdblock = false;
	goto end_state17;
state60:
	bag1holdblock = false;
	if
	:: goto state53;
	:: goto state61;
	fi;
state61:
	bag1holdblock = false;
	if
	:: goto state65;
	:: goto state62;
	fi;
state62:
	bag1holdblock = false;
	if
	:: goto state64;
	:: goto state63;
	fi;
state63:
	bag1holdblock = false;
	if
	:: goto state43;
	:: goto state44;
	fi;
state64:
	bag1holdblock = false;
	if
	:: goto state46;
	:: goto state47;
	fi;
state65:
	bag1holdblock = false;
	if
	:: goto state66;
	:: goto state52;
	fi;
state66:
	bag1holdblock = false;
	if
	:: goto state50;
	:: goto state51;
	fi;
state67:
	bag1holdblock = false;
	if
	:: goto state68;
	:: goto state60;
	fi;
state68:
	bag1holdblock = false;
	if
	:: goto state69;
	:: goto state53;
	fi;
state69:
	bag1holdblock = false;
	if
	:: goto state70;
	:: goto state73;
	fi;
state70:
	bag1holdblock = false;
	if
	:: goto state71;
	:: goto state72;
	fi;
state71:
	bag1holdblock = false;
	if
	:: goto state43;
	:: goto state44;
	fi;
state72:
	bag1holdblock = false;
	if
	:: goto state46;
	:: goto state47;
	fi;
state73:
	bag1holdblock = false;
	if
	:: goto state52;
	:: goto state74;
	fi;
state74:
	bag1holdblock = false;
	if
	:: goto state50;
	:: goto state51;
	fi;
}