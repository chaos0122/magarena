[
    new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                this,
                "Each player sacrifices 4 lands. SN deals 4 damage to each creature."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            for (final MagicPlayer player : game.getAPNAP()) {
                game.addEvent(new MagicRepeatedPermanentsEvent(
                    event.getSource(), 
                    MagicTargetChoice.SACRIFICE_LAND, 
                    4, 
                    MagicChainEventFactory.Sac
                ));
            }
            final Collection<MagicPermanent> targets = game.filterPermanents(MagicTargetFilterFactory.CREATURE);
            for (final MagicPermanent target : targets) {
                game.doAction(new MagicDealDamageAction(event.getSource(), target, 4));
            }
        }
    }
]
