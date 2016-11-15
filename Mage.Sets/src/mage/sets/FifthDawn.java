/*
 * Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets;

import mage.constants.SetType;
import mage.cards.ExpansionSet;
import mage.constants.Rarity;

/**
 *
 * @author North
 */
public class FifthDawn extends ExpansionSet {

    private static final FifthDawn fINSTANCE = new FifthDawn();

    public static FifthDawn getInstance() {
        return fINSTANCE;
    }

    private FifthDawn() {
        super("Fifth Dawn", "5DN", ExpansionSet.buildDate(2004, 5, 4), SetType.EXPANSION);
        this.blockName = "Mirrodin";
        this.parentSet = Mirrodin.getInstance();
        this.hasBasicLands = false;
        this.hasBoosters = true;
        this.numBoosterLands = 0;
        this.numBoosterCommon = 11;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 0;
        cards.add(new SetCardInfo("Abuna's Chant", 1, Rarity.COMMON, mage.cards.a.AbunasChant.class));
        cards.add(new SetCardInfo("Acquire", 21, Rarity.RARE, mage.cards.a.Acquire.class));
        cards.add(new SetCardInfo("Advanced Hoverguard", 22, Rarity.COMMON, mage.cards.a.AdvancedHoverguard.class));
        cards.add(new SetCardInfo("All Suns' Dawn", 81, Rarity.RARE, mage.cards.a.AllSunsDawn.class));
        cards.add(new SetCardInfo("Anodet Lurker", 101, Rarity.COMMON, mage.cards.a.AnodetLurker.class));
        cards.add(new SetCardInfo("Arachnoid", 102, Rarity.UNCOMMON, mage.cards.a.Arachnoid.class));
        cards.add(new SetCardInfo("Arcbound Wanderer", 103, Rarity.UNCOMMON, mage.cards.a.ArcboundWanderer.class));
        cards.add(new SetCardInfo("Armed Response", 2, Rarity.COMMON, mage.cards.a.ArmedResponse.class));
        cards.add(new SetCardInfo("Artificer's Intuition", 23, Rarity.RARE, mage.cards.a.ArtificersIntuition.class));
        cards.add(new SetCardInfo("Auriok Champion", 3, Rarity.RARE, mage.cards.a.AuriokChampion.class));
        cards.add(new SetCardInfo("Auriok Salvagers", 4, Rarity.UNCOMMON, mage.cards.a.AuriokSalvagers.class));
        cards.add(new SetCardInfo("Auriok Windwalker", 5, Rarity.RARE, mage.cards.a.AuriokWindwalker.class));
        cards.add(new SetCardInfo("Avarice Totem", 104, Rarity.UNCOMMON, mage.cards.a.AvariceTotem.class));
        cards.add(new SetCardInfo("Baton of Courage", 105, Rarity.COMMON, mage.cards.b.BatonOfCourage.class));
        cards.add(new SetCardInfo("Battered Golem", 106, Rarity.COMMON, mage.cards.b.BatteredGolem.class));
        cards.add(new SetCardInfo("Beacon of Creation", 82, Rarity.RARE, mage.cards.b.BeaconOfCreation.class));
        cards.add(new SetCardInfo("Beacon of Destruction", 61, Rarity.RARE, mage.cards.b.BeaconOfDestruction.class));
        cards.add(new SetCardInfo("Beacon of Immortality", 6, Rarity.RARE, mage.cards.b.BeaconOfImmortality.class));
        cards.add(new SetCardInfo("Beacon of Tomorrows", 24, Rarity.RARE, mage.cards.b.BeaconOfTomorrows.class));
        cards.add(new SetCardInfo("Beacon of Unrest", 41, Rarity.RARE, mage.cards.b.BeaconOfUnrest.class));
        cards.add(new SetCardInfo("Blasting Station", 107, Rarity.UNCOMMON, mage.cards.b.BlastingStation.class));
        cards.add(new SetCardInfo("Blind Creeper", 42, Rarity.COMMON, mage.cards.b.BlindCreeper.class));
        cards.add(new SetCardInfo("Blinkmoth Infusion", 25, Rarity.RARE, mage.cards.b.BlinkmothInfusion.class));
        cards.add(new SetCardInfo("Bringer of the Black Dawn", 43, Rarity.RARE, mage.cards.b.BringerOfTheBlackDawn.class));
        cards.add(new SetCardInfo("Bringer of the Blue Dawn", 26, Rarity.RARE, mage.cards.b.BringerOfTheBlueDawn.class));
        cards.add(new SetCardInfo("Bringer of the Green Dawn", 83, Rarity.RARE, mage.cards.b.BringerOfTheGreenDawn.class));
        cards.add(new SetCardInfo("Bringer of the Red Dawn", 62, Rarity.RARE, mage.cards.b.BringerOfTheRedDawn.class));
        cards.add(new SetCardInfo("Bringer of the White Dawn", 7, Rarity.RARE, mage.cards.b.BringerOfTheWhiteDawn.class));
        cards.add(new SetCardInfo("Cackling Imp", 44, Rarity.COMMON, mage.cards.c.CacklingImp.class));
        cards.add(new SetCardInfo("Channel the Suns", 84, Rarity.UNCOMMON, mage.cards.c.ChannelTheSuns.class));
        cards.add(new SetCardInfo("Chimeric Coils", 108, Rarity.UNCOMMON, mage.cards.c.ChimericCoils.class));
        cards.add(new SetCardInfo("Circle of Protection: Artifacts", 8, Rarity.UNCOMMON, mage.cards.c.CircleOfProtectionArtifacts.class));
        cards.add(new SetCardInfo("Clearwater Goblet", 109, Rarity.RARE, mage.cards.c.ClearwaterGoblet.class));
        cards.add(new SetCardInfo("Clock of Omens", 110, Rarity.UNCOMMON, mage.cards.c.ClockOfOmens.class));
        cards.add(new SetCardInfo("Composite Golem", 111, Rarity.UNCOMMON, mage.cards.c.CompositeGolem.class));
        cards.add(new SetCardInfo("Condescend", 27, Rarity.COMMON, mage.cards.c.Condescend.class));
        cards.add(new SetCardInfo("Conjurer's Bauble", 112, Rarity.COMMON, mage.cards.c.ConjurersBauble.class));
        cards.add(new SetCardInfo("Cosmic Larva", 63, Rarity.RARE, mage.cards.c.CosmicLarva.class));
        cards.add(new SetCardInfo("Cranial Plating", 113, Rarity.COMMON, mage.cards.c.CranialPlating.class));
        cards.add(new SetCardInfo("Crucible of Worlds", 114, Rarity.RARE, mage.cards.c.CrucibleOfWorlds.class));
        cards.add(new SetCardInfo("Dawn's Reflection", 85, Rarity.COMMON, mage.cards.d.DawnsReflection.class));
        cards.add(new SetCardInfo("Desecration Elemental", 45, Rarity.RARE, mage.cards.d.DesecrationElemental.class));
        cards.add(new SetCardInfo("Devour in Shadow", 46, Rarity.UNCOMMON, mage.cards.d.DevourInShadow.class));
        cards.add(new SetCardInfo("Disruption Aura", 28, Rarity.UNCOMMON, mage.cards.d.DisruptionAura.class));
        cards.add(new SetCardInfo("Door to Nothingness", 115, Rarity.RARE, mage.cards.d.DoorToNothingness.class));
        cards.add(new SetCardInfo("Doubling Cube", 116, Rarity.RARE, mage.cards.d.DoublingCube.class));
        cards.add(new SetCardInfo("Dross Crocodile", 47, Rarity.COMMON, mage.cards.d.DrossCrocodile.class));
        cards.add(new SetCardInfo("Early Frost", 29, Rarity.COMMON, mage.cards.e.EarlyFrost.class));
        cards.add(new SetCardInfo("Ebon Drake", 48, Rarity.UNCOMMON, mage.cards.e.EbonDrake.class));
        cards.add(new SetCardInfo("Endless Whispers", 49, Rarity.RARE, mage.cards.e.EndlessWhispers.class));
        cards.add(new SetCardInfo("Energy Chamber", 117, Rarity.UNCOMMON, mage.cards.e.EnergyChamber.class));
        cards.add(new SetCardInfo("Engineered Explosives", 118, Rarity.RARE, mage.cards.e.EngineeredExplosives.class));
        cards.add(new SetCardInfo("Ensouled Scimitar", 119, Rarity.UNCOMMON, mage.cards.e.EnsouledScimitar.class));
        cards.add(new SetCardInfo("Eon Hub", 120, Rarity.RARE, mage.cards.e.EonHub.class));
        cards.add(new SetCardInfo("Etched Oracle", 121, Rarity.UNCOMMON, mage.cards.e.EtchedOracle.class));
        cards.add(new SetCardInfo("Eternal Witness", 86, Rarity.UNCOMMON, mage.cards.e.EternalWitness.class));
        cards.add(new SetCardInfo("Eyes of the Watcher", 30, Rarity.UNCOMMON, mage.cards.e.EyesOfTheWatcher.class));
        cards.add(new SetCardInfo("Fangren Pathcutter", 87, Rarity.UNCOMMON, mage.cards.f.FangrenPathcutter.class));
        cards.add(new SetCardInfo("Feedback Bolt", 64, Rarity.UNCOMMON, mage.cards.f.FeedbackBolt.class));
        cards.add(new SetCardInfo("Ferocious Charge", 88, Rarity.COMMON, mage.cards.f.FerociousCharge.class));
        cards.add(new SetCardInfo("Ferropede", 122, Rarity.UNCOMMON, mage.cards.f.Ferropede.class));
        cards.add(new SetCardInfo("Fill with Fright", 50, Rarity.COMMON, mage.cards.f.FillWithFright.class));
        cards.add(new SetCardInfo("Fist of Suns", 123, Rarity.RARE, mage.cards.f.FistOfSuns.class));
        cards.add(new SetCardInfo("Fleshgrafter", 51, Rarity.COMMON, mage.cards.f.Fleshgrafter.class));
        cards.add(new SetCardInfo("Fold into Aether", 31, Rarity.UNCOMMON, mage.cards.f.FoldIntoAether.class));
        cards.add(new SetCardInfo("Furnace Whelp", 65, Rarity.UNCOMMON, mage.cards.f.FurnaceWhelp.class));
        cards.add(new SetCardInfo("Gemstone Array", 124, Rarity.UNCOMMON, mage.cards.g.GemstoneArray.class));
        cards.add(new SetCardInfo("Goblin Brawler", 66, Rarity.COMMON, mage.cards.g.GoblinBrawler.class));
        cards.add(new SetCardInfo("Goblin Cannon", 125, Rarity.UNCOMMON, mage.cards.g.GoblinCannon.class));
        cards.add(new SetCardInfo("Grafted Wargear", 126, Rarity.UNCOMMON, mage.cards.g.GraftedWargear.class));
        cards.add(new SetCardInfo("Granulate", 67, Rarity.RARE, mage.cards.g.Granulate.class));
        cards.add(new SetCardInfo("Grinding Station", 127, Rarity.UNCOMMON, mage.cards.g.GrindingStation.class));
        cards.add(new SetCardInfo("Guardian Idol", 128, Rarity.UNCOMMON, mage.cards.g.GuardianIdol.class));
        cards.add(new SetCardInfo("Healer's Headdress", 129, Rarity.COMMON, mage.cards.h.HealersHeaddress.class));
        cards.add(new SetCardInfo("Heliophial", 130, Rarity.COMMON, mage.cards.h.Heliophial.class));
        cards.add(new SetCardInfo("Helm of Kaldra", 131, Rarity.RARE, mage.cards.h.HelmOfKaldra.class));
        cards.add(new SetCardInfo("Horned Helm", 132, Rarity.COMMON, mage.cards.h.HornedHelm.class));
        cards.add(new SetCardInfo("Hoverguard Sweepers", 32, Rarity.RARE, mage.cards.h.HoverguardSweepers.class));
        cards.add(new SetCardInfo("Infused Arrows", 133, Rarity.UNCOMMON, mage.cards.i.InfusedArrows.class));
        cards.add(new SetCardInfo("Into Thin Air", 33, Rarity.COMMON, mage.cards.i.IntoThinAir.class));
        cards.add(new SetCardInfo("Ion Storm", 68, Rarity.RARE, mage.cards.i.IonStorm.class));
        cards.add(new SetCardInfo("Iron-Barb Hellion", 69, Rarity.UNCOMMON, mage.cards.i.IronBarbHellion.class));
        cards.add(new SetCardInfo("Joiner Adept", 89, Rarity.RARE, mage.cards.j.JoinerAdept.class));
        cards.add(new SetCardInfo("Krark-Clan Engineers", 70, Rarity.UNCOMMON, mage.cards.k.KrarkClanEngineers.class));
        cards.add(new SetCardInfo("Krark-Clan Ironworks", 134, Rarity.UNCOMMON, mage.cards.k.KrarkClanIronworks.class));
        cards.add(new SetCardInfo("Krark-Clan Ogre", 71, Rarity.COMMON, mage.cards.k.KrarkClanOgre.class));
        cards.add(new SetCardInfo("Lantern of Insight", 135, Rarity.UNCOMMON, mage.cards.l.LanternOfInsight.class));
        cards.add(new SetCardInfo("Leonin Squire", 9, Rarity.COMMON, mage.cards.l.LeoninSquire.class));
        cards.add(new SetCardInfo("Lose Hope", 52, Rarity.COMMON, mage.cards.l.LoseHope.class));
        cards.add(new SetCardInfo("Loxodon Anchorite", 10, Rarity.COMMON, mage.cards.l.LoxodonAnchorite.class));
        cards.add(new SetCardInfo("Loxodon Stalwart", 11, Rarity.UNCOMMON, mage.cards.l.LoxodonStalwart.class));
        cards.add(new SetCardInfo("Lunar Avenger", 136, Rarity.UNCOMMON, mage.cards.l.LunarAvenger.class));
        cards.add(new SetCardInfo("Magma Giant", 72, Rarity.RARE, mage.cards.m.MagmaGiant.class));
        cards.add(new SetCardInfo("Magma Jet", 73, Rarity.UNCOMMON, mage.cards.m.MagmaJet.class));
        cards.add(new SetCardInfo("Magnetic Theft", 74, Rarity.UNCOMMON, mage.cards.m.MagneticTheft.class));
        cards.add(new SetCardInfo("Mana Geyser", 75, Rarity.COMMON, mage.cards.m.ManaGeyser.class));
        cards.add(new SetCardInfo("Mephidross Vampire", 53, Rarity.RARE, mage.cards.m.MephidrossVampire.class));
        cards.add(new SetCardInfo("Moriok Rigger", 54, Rarity.RARE, mage.cards.m.MoriokRigger.class));
        cards.add(new SetCardInfo("Mycosynth Golem", 137, Rarity.RARE, mage.cards.m.MycosynthGolem.class));
        cards.add(new SetCardInfo("Myr Quadropod", 138, Rarity.COMMON, mage.cards.m.MyrQuadropod.class));
        cards.add(new SetCardInfo("Myr Servitor", 139, Rarity.COMMON, mage.cards.m.MyrServitor.class));
        cards.add(new SetCardInfo("Neurok Stealthsuit", 140, Rarity.COMMON, mage.cards.n.NeurokStealthsuit.class));
        cards.add(new SetCardInfo("Night's Whisper", 55, Rarity.UNCOMMON, mage.cards.n.NightsWhisper.class));
        cards.add(new SetCardInfo("Nim Grotesque", 56, Rarity.UNCOMMON, mage.cards.n.NimGrotesque.class));
        cards.add(new SetCardInfo("Opaline Bracers", 141, Rarity.COMMON, mage.cards.o.OpalineBracers.class));
        cards.add(new SetCardInfo("Paradise Mantle", 142, Rarity.UNCOMMON, mage.cards.p.ParadiseMantle.class));
        cards.add(new SetCardInfo("Pentad Prism", 143, Rarity.COMMON, mage.cards.p.PentadPrism.class));
        cards.add(new SetCardInfo("Plasma Elemental", 34, Rarity.UNCOMMON, mage.cards.p.PlasmaElemental.class));
        cards.add(new SetCardInfo("Plunge into Darkness", 57, Rarity.RARE, mage.cards.p.PlungeIntoDarkness.class));
        cards.add(new SetCardInfo("Possessed Portal", 144, Rarity.RARE, mage.cards.p.PossessedPortal.class));
        cards.add(new SetCardInfo("Qumulox", 35, Rarity.UNCOMMON, mage.cards.q.Qumulox.class));
        cards.add(new SetCardInfo("Rain of Rust", 76, Rarity.COMMON, mage.cards.r.RainOfRust.class));
        cards.add(new SetCardInfo("Raksha Golden Cub", 12, Rarity.RARE, mage.cards.r.RakshaGoldenCub.class));
        cards.add(new SetCardInfo("Razorgrass Screen", 145, Rarity.COMMON, mage.cards.r.RazorgrassScreen.class));
        cards.add(new SetCardInfo("Razormane Masticore", 146, Rarity.RARE, mage.cards.r.RazormaneMasticore.class));
        cards.add(new SetCardInfo("Relentless Rats", 58, Rarity.UNCOMMON, mage.cards.r.RelentlessRats.class));
        cards.add(new SetCardInfo("Relic Barrier", 147, Rarity.UNCOMMON, mage.cards.r.RelicBarrier.class));
        cards.add(new SetCardInfo("Retaliate", 13, Rarity.RARE, mage.cards.r.Retaliate.class));
        cards.add(new SetCardInfo("Reversal of Fortune", 77, Rarity.RARE, mage.cards.r.ReversalOfFortune.class));
        cards.add(new SetCardInfo("Rite of Passage", 91, Rarity.RARE, mage.cards.r.RiteOfPassage.class));
        cards.add(new SetCardInfo("Roar of Reclamation", 14, Rarity.RARE, mage.cards.r.RoarOfReclamation.class));
        cards.add(new SetCardInfo("Rude Awakening", 92, Rarity.RARE, mage.cards.r.RudeAwakening.class));
        cards.add(new SetCardInfo("Salvaging Station", 148, Rarity.RARE, mage.cards.s.SalvagingStation.class));
        cards.add(new SetCardInfo("Sawtooth Thresher", 149, Rarity.COMMON, mage.cards.s.SawtoothThresher.class));
        cards.add(new SetCardInfo("Screaming Fury", 78, Rarity.COMMON, mage.cards.s.ScreamingFury.class));
        cards.add(new SetCardInfo("Serum Visions", 36, Rarity.COMMON, mage.cards.s.SerumVisions.class));
        cards.add(new SetCardInfo("Shattered Dreams", 59, Rarity.UNCOMMON, mage.cards.s.ShatteredDreams.class));
        cards.add(new SetCardInfo("Silent Arbiter", 150, Rarity.RARE, mage.cards.s.SilentArbiter.class));
        cards.add(new SetCardInfo("Skullcage", 151, Rarity.UNCOMMON, mage.cards.s.Skullcage.class));
        cards.add(new SetCardInfo("Skyhunter Prowler", 15, Rarity.COMMON, mage.cards.s.SkyhunterProwler.class));
        cards.add(new SetCardInfo("Skyhunter Skirmisher", 16, Rarity.UNCOMMON, mage.cards.s.SkyhunterSkirmisher.class));
        cards.add(new SetCardInfo("Skyreach Manta", 152, Rarity.COMMON, mage.cards.s.SkyreachManta.class));
        cards.add(new SetCardInfo("Solarion", 153, Rarity.RARE, mage.cards.s.Solarion.class));
        cards.add(new SetCardInfo("Spark Elemental", 79, Rarity.COMMON, mage.cards.s.SparkElemental.class));
        cards.add(new SetCardInfo("Sparring Collar", 154, Rarity.COMMON, mage.cards.s.SparringCollar.class));
        cards.add(new SetCardInfo("Spinal Parasite", 155, Rarity.UNCOMMON, mage.cards.s.SpinalParasite.class));
        cards.add(new SetCardInfo("Staff of Domination", 156, Rarity.RARE, mage.cards.s.StaffOfDomination.class));
        cards.add(new SetCardInfo("Stand Firm", 17, Rarity.COMMON, mage.cards.s.StandFirm.class));
        cards.add(new SetCardInfo("Stasis Cocoon", 18, Rarity.COMMON, mage.cards.s.StasisCocoon.class));
        cards.add(new SetCardInfo("Steelshaper's Gift", 19, Rarity.UNCOMMON, mage.cards.s.SteelshapersGift.class));
        cards.add(new SetCardInfo("Summoner's Egg", 157, Rarity.RARE, mage.cards.s.SummonersEgg.class));
        cards.add(new SetCardInfo("Summoning Station", 158, Rarity.RARE, mage.cards.s.SummoningStation.class));
        cards.add(new SetCardInfo("Suncrusher", 159, Rarity.RARE, mage.cards.s.Suncrusher.class));
        cards.add(new SetCardInfo("Suntouched Myr", 160, Rarity.COMMON, mage.cards.s.SuntouchedMyr.class));
        cards.add(new SetCardInfo("Sylvok Explorer", 93, Rarity.COMMON, mage.cards.s.SylvokExplorer.class));
        cards.add(new SetCardInfo("Synod Centurion", 161, Rarity.UNCOMMON, mage.cards.s.SynodCenturion.class));
        cards.add(new SetCardInfo("Tangle Asp", 94, Rarity.COMMON, mage.cards.t.TangleAsp.class));
        cards.add(new SetCardInfo("Tel-Jilad Justice", 95, Rarity.UNCOMMON, mage.cards.t.TelJiladJustice.class));
        cards.add(new SetCardInfo("Tel-Jilad Lifebreather", 96, Rarity.COMMON, mage.cards.t.TelJiladLifebreather.class));
        cards.add(new SetCardInfo("Thermal Navigator", 162, Rarity.COMMON, mage.cards.t.ThermalNavigator.class));
        cards.add(new SetCardInfo("Thought Courier", 38, Rarity.COMMON, mage.cards.t.ThoughtCourier.class));
        cards.add(new SetCardInfo("Tornado Elemental", 97, Rarity.RARE, mage.cards.t.TornadoElemental.class));
        cards.add(new SetCardInfo("Trinket Mage", 39, Rarity.COMMON, mage.cards.t.TrinketMage.class));
        cards.add(new SetCardInfo("Tyrranax", 98, Rarity.COMMON, mage.cards.t.Tyrranax.class));
        cards.add(new SetCardInfo("Vanquish", 20, Rarity.UNCOMMON, mage.cards.v.Vanquish.class));
        cards.add(new SetCardInfo("Vedalken Mastermind", 40, Rarity.UNCOMMON, mage.cards.v.VedalkenMastermind.class));
        cards.add(new SetCardInfo("Vedalken Orrery", 163, Rarity.RARE, mage.cards.v.VedalkenOrrery.class));
        cards.add(new SetCardInfo("Vedalken Shackles", 164, Rarity.RARE, mage.cards.v.VedalkenShackles.class));
        cards.add(new SetCardInfo("Vicious Betrayal", 60, Rarity.COMMON, mage.cards.v.ViciousBetrayal.class));
        cards.add(new SetCardInfo("Viridian Lorebearers", 99, Rarity.UNCOMMON, mage.cards.v.ViridianLorebearers.class));
        cards.add(new SetCardInfo("Viridian Scout", 100, Rarity.COMMON, mage.cards.v.ViridianScout.class));
        cards.add(new SetCardInfo("Vulshok Sorcerer", 80, Rarity.COMMON, mage.cards.v.VulshokSorcerer.class));
        cards.add(new SetCardInfo("Wayfarer's Bauble", 165, Rarity.COMMON, mage.cards.w.WayfarersBauble.class));
    }
}
