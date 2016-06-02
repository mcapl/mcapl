never { /* !(<>bag1holdblock)  */
accept_init:
        if
        :: (!bag1holdblock) -> goto accept_init
        fi;
}
