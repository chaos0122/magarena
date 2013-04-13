[
    new MagicLandfallTrigger() {
        @Override
        public MagicEvent getEvent(final MagicPermanent permanent) {
            return new MagicEvent(
                permanent,
                this,
                "SN gains vigilance until end of turn."
            );
        }
        
        @Override
        public void executeEvent(
                final MagicGame game,
                final MagicEvent event) {
            game.doAction(new MagicSetAbilityAction(
                event.getPermanent(),
                MagicAbility.Vigilance
            ));
        }        
    }
]
