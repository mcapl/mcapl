bool bag1holdblock

active proctype JPFModel()
{
state0:
	bag1holdblock = true;
	if
	:: goto state1;
	:: goto state62;
	fi;
state1:
	bag1holdblock = true;
	if
	:: goto state2;
	:: goto state39;
	fi;
end_state2:
	bag1holdblock = false;
	printf("end state\n");
state2:
	bag1holdblock = true;
	if
	:: goto state3;
	:: goto state23;
	fi;
end_state3:
	bag1holdblock = false;
	printf("end state\n");
state3:
	bag1holdblock = true;
	if
	:: goto state4;
	:: goto state14;
	fi;
end_state4:
	bag1holdblock = false;
	printf("end state\n");
state4:
	bag1holdblock = true;
	if
	:: goto state5;
	:: goto state12;
	fi;
end_state5:
	bag1holdblock = false;
	printf("end state\n");
state5:
	bag1holdblock = true;
	goto state6;
end_state6:
	bag1holdblock = false;
	printf("end state\n");
state6:
	bag1holdblock = true;
	if
	:: goto state7;
	:: goto state10;
	fi;
end_state7:
	bag1holdblock = false;
	printf("end state\n");
state7:
	bag1holdblock = true;
	goto state8;
end_state8:
	bag1holdblock = false;
	printf("end state\n");
state8:
	bag1holdblock = false;
	goto end_state2;
end_state9:
	bag1holdblock = false;
	printf("end state\n");
end_state10:
	bag1holdblock = false;
	printf("end state\n");
state10:
	bag1holdblock = false;
	goto state11;
end_state11:
	bag1holdblock = false;
	printf("end state\n");
state11:
	bag1holdblock = false;
	goto end_state3;
end_state12:
	bag1holdblock = false;
	printf("end state\n");
state12:
	bag1holdblock = true;
	if
	:: goto state7;
	:: goto state13;
	fi;
end_state13:
	bag1holdblock = false;
	printf("end state\n");
state13:
	bag1holdblock = false;
	goto state11;
end_state14:
	bag1holdblock = false;
	printf("end state\n");
state14:
	bag1holdblock = true;
	if
	:: goto state21;
	:: goto state15;
	fi;
end_state15:
	bag1holdblock = false;
	printf("end state\n");
state15:
	bag1holdblock = true;
	goto state16;
end_state16:
	bag1holdblock = false;
	printf("end state\n");
state16:
	bag1holdblock = true;
	if
	:: goto state17;
	:: goto state19;
	fi;
end_state17:
	bag1holdblock = false;
	printf("end state\n");
state17:
	bag1holdblock = true;
	goto state18;
state18:
	bag1holdblock = false;
	goto end_state4;
state19:
	bag1holdblock = false;
	goto state20;
state20:
	bag1holdblock = false;
	goto end_state5;
state21:
	bag1holdblock = true;
	if
	:: goto state17;
	:: goto state22;
	fi;
state22:
	bag1holdblock = false;
	goto state20;
state23:
	bag1holdblock = true;
	if
	:: goto state33;
	:: goto state24;
	fi;
state24:
	bag1holdblock = true;
	if
	:: goto state25;
	:: goto state31;
	fi;
state25:
	bag1holdblock = true;
	goto state26;
state26:
	bag1holdblock = true;
	if
	:: goto state27;
	:: goto state29;
	fi;
state27:
	bag1holdblock = true;
	goto state28;
state28:
	bag1holdblock = false;
	goto end_state6;
state29:
	bag1holdblock = false;
	goto state30;
state30:
	bag1holdblock = false;
	goto end_state7;
state31:
	bag1holdblock = true;
	if
	:: goto state32;
	:: goto state27;
	fi;
state32:
	bag1holdblock = false;
	goto state30;
state33:
	bag1holdblock = true;
	goto state34;
state34:
	bag1holdblock = true;
	if
	:: goto state35;
	:: goto state37;
	fi;
state35:
	bag1holdblock = true;
	goto state36;
state36:
	bag1holdblock = false;
	goto end_state8;
state37:
	bag1holdblock = false;
	goto state38;
state38:
	bag1holdblock = false;
	goto end_state9;
state39:
	bag1holdblock = true;
	if
	:: goto state52;
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
	bag1holdblock = true;
	goto state8;
state44:
	bag1holdblock = false;
	goto state11;
state45:
	bag1holdblock = true;
	if
	:: goto state46;
	:: goto state47;
	fi;
state46:
	bag1holdblock = true;
	goto state18;
state47:
	bag1holdblock = false;
	goto state20;
state48:
	bag1holdblock = true;
	if
	:: goto state49;
	:: goto state35;
	fi;
state49:
	bag1holdblock = true;
	if
	:: goto state50;
	:: goto state51;
	fi;
state50:
	bag1holdblock = true;
	goto state28;
state51:
	bag1holdblock = false;
	goto state30;
state52:
	bag1holdblock = false;
	goto state53;
state53:
	bag1holdblock = false;
	if
	:: goto state54;
	:: goto state59;
	fi;
state54:
	bag1holdblock = false;
	if
	:: goto state55;
	:: goto state57;
	fi;
state55:
	bag1holdblock = false;
	if
	:: goto state56;
	:: goto state44;
	fi;
state56:
	bag1holdblock = false;
	goto state8;
state57:
	bag1holdblock = false;
	if
	:: goto state58;
	:: goto state47;
	fi;
state58:
	bag1holdblock = false;
	goto state18;
state59:
	bag1holdblock = false;
	if
	:: goto state38;
	:: goto state60;
	fi;
state60:
	bag1holdblock = false;
	if
	:: goto state51;
	:: goto state61;
	fi;
state61:
	bag1holdblock = false;
	goto state28;
state62:
	bag1holdblock = true;
	if
	:: goto state108;
	:: goto state63;
	fi;
state63:
	bag1holdblock = true;
	if
	:: goto state64;
	:: goto state96;
	fi;
state64:
	bag1holdblock = true;
	if
	:: goto state65;
	:: goto state85;
	fi;
state65:
	bag1holdblock = true;
	if
	:: goto state66;
	:: goto state77;
	fi;
state66:
	bag1holdblock = true;
	if
	:: goto state67;
	:: goto state72;
	fi;
state67:
	bag1holdblock = true;
	if
	:: goto state68;
	:: goto state70;
	fi;
state68:
	bag1holdblock = true;
	goto state69;
state69:
	bag1holdblock = false;
	goto end_state10;
state70:
	bag1holdblock = false;
	goto state71;
state71:
	bag1holdblock = false;
	goto end_state11;
state72:
	bag1holdblock = true;
	if
	:: goto state73;
	:: goto state75;
	fi;
state73:
	bag1holdblock = true;
	goto state74;
state74:
	bag1holdblock = false;
	goto end_state12;
state75:
	bag1holdblock = false;
	goto state76;
state76:
	bag1holdblock = false;
	goto end_state13;
state77:
	bag1holdblock = true;
	if
	:: goto state83;
	:: goto state78;
	fi;
state78:
	bag1holdblock = true;
	if
	:: goto state81;
	:: goto state79;
	fi;
state79:
	bag1holdblock = true;
	goto state80;
state80:
	bag1holdblock = false;
	goto end_state14;
state81:
	bag1holdblock = false;
	goto state82;
state82:
	bag1holdblock = false;
	goto end_state15;
state83:
	bag1holdblock = true;
	goto state84;
state84:
	bag1holdblock = false;
	goto end_state16;
state85:
	bag1holdblock = false;
	goto state86;
state86:
	bag1holdblock = false;
	if
	:: goto state87;
	:: goto state92;
	fi;
state87:
	bag1holdblock = false;
	if
	:: goto state88;
	:: goto state90;
	fi;
state88:
	bag1holdblock = false;
	if
	:: goto state70;
	:: goto state89;
	fi;
state89:
	bag1holdblock = false;
	goto state69;
state90:
	bag1holdblock = false;
	if
	:: goto state91;
	:: goto state75;
	fi;
state91:
	bag1holdblock = false;
	goto state74;
state92:
	bag1holdblock = false;
	if
	:: goto state93;
	:: goto state95;
	fi;
state93:
	bag1holdblock = false;
	if
	:: goto state81;
	:: goto state94;
	fi;
state94:
	bag1holdblock = false;
	goto state80;
state95:
	bag1holdblock = false;
	goto end_state17;
state96:
	bag1holdblock = false;
	goto state97;
state97:
	bag1holdblock = false;
	if
	:: goto state98;
	:: goto state85;
	fi;
state98:
	bag1holdblock = false;
	if
	:: goto state99;
	:: goto state104;
	fi;
state99:
	bag1holdblock = false;
	if
	:: goto state100;
	:: goto state102;
	fi;
state100:
	bag1holdblock = false;
	if
	:: goto state101;
	:: goto state70;
	fi;
state101:
	bag1holdblock = false;
	goto state69;
state102:
	bag1holdblock = false;
	if
	:: goto state103;
	:: goto state75;
	fi;
state103:
	bag1holdblock = false;
	goto state74;
state104:
	bag1holdblock = false;
	if
	:: goto state105;
	:: goto state107;
	fi;
state105:
	bag1holdblock = false;
	if
	:: goto state81;
	:: goto state106;
	fi;
state106:
	bag1holdblock = false;
	goto state80;
state107:
	bag1holdblock = false;
	goto state84;
state108:
	bag1holdblock = false;
	goto state109;
state109:
	bag1holdblock = false;
	if
	:: goto state96;
	:: goto state110;
	fi;
state110:
	bag1holdblock = false;
	if
	:: goto state85;
	:: goto state111;
	fi;
state111:
	bag1holdblock = false;
	if
	:: goto state112;
	:: goto state117;
	fi;
state112:
	bag1holdblock = false;
	if
	:: goto state113;
	:: goto state115;
	fi;
state113:
	bag1holdblock = false;
	if
	:: goto state114;
	:: goto state70;
	fi;
state114:
	bag1holdblock = false;
	goto state69;
state115:
	bag1holdblock = false;
	if
	:: goto state116;
	:: goto state75;
	fi;
state116:
	bag1holdblock = false;
	goto state74;
state117:
	bag1holdblock = false;
	if
	:: goto state118;
	:: goto state120;
	fi;
state118:
	bag1holdblock = false;
	if
	:: goto state81;
	:: goto state119;
	fi;
state119:
	bag1holdblock = false;
	goto state80;
state120:
	bag1holdblock = false;
	goto state84;
}