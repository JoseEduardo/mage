/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets;

import java.util.GregorianCalendar;
import mage.cards.ExpansionSet;
import mage.constants.SetType;
import mage.constants.Rarity;
import java.util.List;
import mage.ObjectColor;
import mage.cards.CardGraphicInfo;
import mage.cards.FrameStyle;

/**
 *
 * @author fireshoes
 */

public class Commander2015 extends ExpansionSet {

    private static final Commander2015 fINSTANCE = new Commander2015();

    public static Commander2015 getInstance() {
        return fINSTANCE;
    }

    private Commander2015() {
        super("Commander 2015 Edition", "C15", "mage.sets.commander2015", ExpansionSet.buildDate(2015, 11, 13), SetType.SUPPLEMENTAL);
        this.blockName = "Command Zone";
        cards.add(new SetCardInfo("Acidic Slime", 173, Rarity.UNCOMMON, mage.cards.a.AcidicSlime.class));
        cards.add(new SetCardInfo("Act of Aggression", 141, Rarity.UNCOMMON, mage.cards.a.ActOfAggression.class));
        cards.add(new SetCardInfo("Aetherize", 85, Rarity.UNCOMMON, mage.cards.a.Aetherize.class));
        cards.add(new SetCardInfo("Aethersnatch", 9, Rarity.RARE, mage.cards.a.Aethersnatch.class));
        cards.add(new SetCardInfo("Ajani's Chosen", 57, Rarity.RARE, mage.cards.a.AjanisChosen.class));
        cards.add(new SetCardInfo("Altar's Reap", 112, Rarity.COMMON, mage.cards.a.AltarsReap.class));
        cards.add(new SetCardInfo("Ambition's Cost", 113, Rarity.UNCOMMON, mage.cards.a.AmbitionsCost.class));
        cards.add(new SetCardInfo("Ancient Amphitheater", 276, Rarity.RARE, mage.cards.a.AncientAmphitheater.class));
        cards.add(new SetCardInfo("Ancient Craving", 114, Rarity.RARE, mage.cards.a.AncientCraving.class));
        cards.add(new SetCardInfo("Angel of Serenity", 58, Rarity.MYTHIC, mage.cards.a.AngelOfSerenity.class));
        cards.add(new SetCardInfo("Anya, Merciless Angel", 41, Rarity.MYTHIC, mage.cards.a.AnyaMercilessAngel.class));
        cards.add(new SetCardInfo("Arachnogenesis", 32, Rarity.RARE, mage.cards.a.Arachnogenesis.class));
        cards.add(new SetCardInfo("Arbiter of Knollridge", 59, Rarity.RARE, mage.cards.a.ArbiterOfKnollridge.class));
        cards.add(new SetCardInfo("Arbor Colossus", 174, Rarity.RARE, mage.cards.a.ArborColossus.class));
        cards.add(new SetCardInfo("Arjun, the Shifting Flame", 42, Rarity.MYTHIC, mage.cards.a.ArjunTheShiftingFlame.class));
        cards.add(new SetCardInfo("Aura of Silence", 60, Rarity.UNCOMMON, mage.cards.a.AuraOfSilence.class));
        cards.add(new SetCardInfo("Awaken the Sky Tyrant", 24, Rarity.RARE, mage.cards.a.AwakenTheSkyTyrant.class));
        cards.add(new SetCardInfo("Bane of Progress", 175, Rarity.RARE, mage.cards.b.BaneOfProgress.class));
        cards.add(new SetCardInfo("Banishing Light", 61, Rarity.UNCOMMON, mage.cards.b.BanishingLight.class));
        cards.add(new SetCardInfo("Banshee of the Dread Choir", 16, Rarity.UNCOMMON, mage.cards.b.BansheeOfTheDreadChoir.class));
        cards.add(new SetCardInfo("Barren Moor", 277, Rarity.COMMON, mage.cards.b.BarrenMoor.class));
        cards.add(new SetCardInfo("Barter in Blood", 115, Rarity.UNCOMMON, mage.cards.b.BarterInBlood.class));
        cards.add(new SetCardInfo("Basalt Monolith", 244, Rarity.UNCOMMON, mage.cards.b.BasaltMonolith.class));
        cards.add(new SetCardInfo("Bastion Protector", 1, Rarity.RARE, mage.cards.b.BastionProtector.class));
        cards.add(new SetCardInfo("Beastmaster Ascension", 176, Rarity.RARE, mage.cards.b.BeastmasterAscension.class));
        cards.add(new SetCardInfo("Bident of Thassa", 86, Rarity.RARE, mage.cards.b.BidentOfThassa.class));
        cards.add(new SetCardInfo("Biomantic Mastery", 239, Rarity.RARE, mage.cards.b.BiomanticMastery.class));
        cards.add(new SetCardInfo("Black Market", 116, Rarity.RARE, mage.cards.b.BlackMarket.class));
        cards.add(new SetCardInfo("Blade of Selves", 51, Rarity.RARE, mage.cards.b.BladeOfSelves.class));
        cards.add(new SetCardInfo("Blasted Landscape", 278, Rarity.UNCOMMON, mage.cards.b.BlastedLandscape.class));
        cards.add(new SetCardInfo("Blatant Thievery", 87, Rarity.RARE, mage.cards.b.BlatantThievery.class));
        cards.add(new SetCardInfo("Blood Bairn", 117, Rarity.COMMON, mage.cards.b.BloodBairn.class));
        cards.add(new SetCardInfo("Bloodspore Thrinax", 33, Rarity.RARE, mage.cards.b.BloodsporeThrinax.class));
        cards.add(new SetCardInfo("Blue Sun's Zenith", 88, Rarity.RARE, mage.cards.b.BlueSunsZenith.class));
        cards.add(new SetCardInfo("Blustersquall", 89, Rarity.UNCOMMON, mage.cards.b.Blustersquall.class));
        cards.add(new SetCardInfo("Bonehoard", 245, Rarity.RARE, mage.cards.b.Bonehoard.class));
        cards.add(new SetCardInfo("Borderland Behemoth", 142, Rarity.RARE, mage.cards.b.BorderlandBehemoth.class));
        cards.add(new SetCardInfo("Boros Cluestone", 246, Rarity.COMMON, mage.cards.b.BorosCluestone.class));
        cards.add(new SetCardInfo("Boros Garrison", 279, Rarity.COMMON, mage.cards.b.BorosGarrison.class));
        cards.add(new SetCardInfo("Boros Guildgate", 280, Rarity.COMMON, mage.cards.b.BorosGuildgate.class));
        cards.add(new SetCardInfo("Boros Signet", 247, Rarity.COMMON, mage.cards.b.BorosSignet.class));
        cards.add(new SetCardInfo("Brainstorm", 90, Rarity.COMMON, mage.cards.b.Brainstorm.class));
        cards.add(new SetCardInfo("Breath of Darigaaz", 143, Rarity.UNCOMMON, mage.cards.b.BreathOfDarigaaz.class));
        cards.add(new SetCardInfo("Broodbirth Viper", 10, Rarity.UNCOMMON, mage.cards.b.BroodbirthViper.class));
        cards.add(new SetCardInfo("Burnished Hart", 248, Rarity.UNCOMMON, mage.cards.b.BurnishedHart.class));
        cards.add(new SetCardInfo("Butcher of Malakir", 118, Rarity.RARE, mage.cards.b.ButcherOfMalakir.class));
        cards.add(new SetCardInfo("Cage of Hands", 62, Rarity.COMMON, mage.cards.c.CageOfHands.class));
        cards.add(new SetCardInfo("Caller of the Claw", 177, Rarity.RARE, mage.cards.c.CallerOfTheClaw.class));
        cards.add(new SetCardInfo("Caller of the Pack", 34, Rarity.UNCOMMON, mage.cards.c.CallerOfThePack.class));
        cards.add(new SetCardInfo("Call the Skybreaker", 240, Rarity.RARE, mage.cards.c.CallTheSkybreaker.class));
        cards.add(new SetCardInfo("Celestial Ancient", 63, Rarity.RARE, mage.cards.c.CelestialAncient.class));
        cards.add(new SetCardInfo("Celestial Archon", 64, Rarity.RARE, mage.cards.c.CelestialArchon.class));
        cards.add(new SetCardInfo("Centaur Vinecrasher", 35, Rarity.RARE, mage.cards.c.CentaurVinecrasher.class));
        cards.add(new SetCardInfo("Chain Reaction", 144, Rarity.RARE, mage.cards.c.ChainReaction.class));
        cards.add(new SetCardInfo("Chameleon Colossus", 178, Rarity.RARE, mage.cards.c.ChameleonColossus.class));
        cards.add(new SetCardInfo("Champion of Stray Souls", 119, Rarity.MYTHIC, mage.cards.c.ChampionOfStraySouls.class));
        cards.add(new SetCardInfo("Charmbreaker Devils", 145, Rarity.RARE, mage.cards.c.CharmbreakerDevils.class));
        cards.add(new SetCardInfo("Cloudthresher", 179, Rarity.RARE, mage.cards.c.Cloudthresher.class));
        cards.add(new SetCardInfo("Cobra Trap", 180, Rarity.UNCOMMON, mage.cards.c.CobraTrap.class));
        cards.add(new SetCardInfo("Coiling Oracle", 213, Rarity.COMMON, mage.cards.c.CoilingOracle.class));
        cards.add(new SetCardInfo("Cold-Eyed Selkie", 241, Rarity.RARE, mage.cards.c.ColdEyedSelkie.class));
        cards.add(new SetCardInfo("Coldsteel Heart", 249, Rarity.UNCOMMON, mage.cards.c.ColdsteelHeart.class));
        cards.add(new SetCardInfo("Comet Storm", 146, Rarity.MYTHIC, mage.cards.c.CometStorm.class));
        cards.add(new SetCardInfo("Command Beacon", 56, Rarity.RARE, mage.cards.c.CommandBeacon.class));
        cards.add(new SetCardInfo("Command Tower", 281, Rarity.COMMON, mage.cards.c.CommandTower.class));
        cards.add(new SetCardInfo("Corpse Augur", 17, Rarity.UNCOMMON, mage.cards.c.CorpseAugur.class));
        cards.add(new SetCardInfo("Counterflux", 214, Rarity.RARE, mage.cards.c.Counterflux.class));
        cards.add(new SetCardInfo("Crib Swap", 65, Rarity.UNCOMMON, mage.cards.c.CribSwap.class));
        cards.add(new SetCardInfo("Crystal Chimes", 250, Rarity.UNCOMMON, mage.cards.c.CrystalChimes.class));
        cards.add(new SetCardInfo("Curse of the Nightly Hunt", 147, Rarity.UNCOMMON, mage.cards.c.CurseOfTheNightlyHunt.class));
        cards.add(new SetCardInfo("Darksteel Ingot", 251, Rarity.UNCOMMON, mage.cards.d.DarksteelIngot.class));
        cards.add(new SetCardInfo("Dawnbreak Reclaimer", 2, Rarity.RARE, mage.cards.d.DawnbreakReclaimer.class));
        cards.add(new SetCardInfo("Dawnglare Invoker", 67, Rarity.COMMON, mage.cards.d.DawnglareInvoker.class));
        cards.add(new SetCardInfo("Dawn to Dusk", 66, Rarity.UNCOMMON, mage.cards.d.DawnToDusk.class));
        cards.add(new SetCardInfo("Daxos's Torment", 18, Rarity.RARE, mage.cards.d.DaxossTorment.class));
        cards.add(new SetCardInfo("Daxos the Returned", 43, Rarity.MYTHIC, mage.cards.d.DaxosTheReturned.class));
        cards.add(new SetCardInfo("Day of the Dragons", 91, Rarity.RARE, mage.cards.d.DayOfTheDragons.class));
        cards.add(new SetCardInfo("Deadly Tempest", 19, Rarity.RARE, mage.cards.d.DeadlyTempest.class));
        cards.add(new SetCardInfo("Death Grasp", 215, Rarity.RARE, mage.cards.d.DeathGrasp.class));
        cards.add(new SetCardInfo("Desert Twister", 181, Rarity.UNCOMMON, mage.cards.d.DesertTwister.class));
        cards.add(new SetCardInfo("Desolation Giant", 148, Rarity.RARE, mage.cards.d.DesolationGiant.class));
        cards.add(new SetCardInfo("Desperate Ravings", 149, Rarity.UNCOMMON, mage.cards.d.DesperateRavings.class));
        cards.add(new SetCardInfo("Diabolic Servitude", 120, Rarity.UNCOMMON, mage.cards.d.DiabolicServitude.class));
        cards.add(new SetCardInfo("Dictate of Heliod", 68, Rarity.RARE, mage.cards.d.DictateOfHeliod.class));
        cards.add(new SetCardInfo("Disaster Radius", 150, Rarity.RARE, mage.cards.d.DisasterRadius.class));
        cards.add(new SetCardInfo("Dominate", 92, Rarity.UNCOMMON, mage.cards.d.Dominate.class));
        cards.add(new SetCardInfo("Doomwake Giant", 121, Rarity.RARE, mage.cards.d.DoomwakeGiant.class));
        cards.add(new SetCardInfo("Dragon Mage", 151, Rarity.RARE, mage.cards.d.DragonMage.class));
        cards.add(new SetCardInfo("Dreadbringer Lampads", 122, Rarity.COMMON, mage.cards.d.DreadbringerLampads.class));
        cards.add(new SetCardInfo("Dread Summons", 20, Rarity.RARE, mage.cards.d.DreadSummons.class));
        cards.add(new SetCardInfo("Dream Pillager", 25, Rarity.RARE, mage.cards.d.DreamPillager.class));
        cards.add(new SetCardInfo("Dreamstone Hedron", 252, Rarity.UNCOMMON, mage.cards.d.DreamstoneHedron.class));
        cards.add(new SetCardInfo("Drifting Meadow", 282, Rarity.COMMON, mage.cards.d.DriftingMeadow.class));
        cards.add(new SetCardInfo("Earthquake", 152, Rarity.RARE, mage.cards.e.Earthquake.class));
        cards.add(new SetCardInfo("Eater of Hope", 123, Rarity.RARE, mage.cards.e.EaterOfHope.class));
        cards.add(new SetCardInfo("Echoing Truth", 93, Rarity.COMMON, mage.cards.e.EchoingTruth.class));
        cards.add(new SetCardInfo("Eldrazi Monument", 253, Rarity.MYTHIC, mage.cards.e.EldraziMonument.class));
        cards.add(new SetCardInfo("Elvish Visionary", 182, Rarity.COMMON, mage.cards.e.ElvishVisionary.class));
        cards.add(new SetCardInfo("Epic Experiment", 216, Rarity.MYTHIC, mage.cards.e.EpicExperiment.class));
        cards.add(new SetCardInfo("Eternal Witness", 183, Rarity.UNCOMMON, mage.cards.e.EternalWitness.class));
        cards.add(new SetCardInfo("Etherium-Horn Sorcerer", 217, Rarity.RARE, mage.cards.e.EtheriumHornSorcerer.class));
        cards.add(new SetCardInfo("Evolving Wilds", 283, Rarity.COMMON, mage.cards.e.EvolvingWilds.class));
        cards.add(new SetCardInfo("Experiment One", 184, Rarity.UNCOMMON, mage.cards.e.ExperimentOne.class));
        cards.add(new SetCardInfo("Extractor Demon", 124, Rarity.RARE, mage.cards.e.ExtractorDemon.class));
        cards.add(new SetCardInfo("Ezuri, Claw of Progress", 44, Rarity.MYTHIC, mage.cards.e.EzuriClawOfProgress.class));
        cards.add(new SetCardInfo("Ezuri's Predation", 36, Rarity.RARE, mage.cards.e.EzurisPredation.class));
        cards.add(new SetCardInfo("Fact or Fiction", 94, Rarity.UNCOMMON, mage.cards.f.FactOrFiction.class));
        cards.add(new SetCardInfo("Faithless Looting", 153, Rarity.COMMON, mage.cards.f.FaithlessLooting.class));
        cards.add(new SetCardInfo("Faith's Fetters", 69, Rarity.COMMON, mage.cards.f.FaithsFetters.class));
        cards.add(new SetCardInfo("Fallen Ideal", 125, Rarity.UNCOMMON, mage.cards.f.FallenIdeal.class));
        cards.add(new SetCardInfo("Fall of the Hammer", 154, Rarity.COMMON, mage.cards.f.FallOfTheHammer.class));
        cards.add(new SetCardInfo("Fate Unraveler", 126, Rarity.RARE, mage.cards.f.FateUnraveler.class));
        cards.add(new SetCardInfo("Fellwar Stone", 254, Rarity.UNCOMMON, mage.cards.f.FellwarStone.class));
        cards.add(new SetCardInfo("Fiery Confluence", 26, Rarity.RARE, mage.cards.f.FieryConfluence.class));
        cards.add(new SetCardInfo("Firemind's Foresight", 218, Rarity.RARE, mage.cards.f.FiremindsForesight.class));
        cards.add(new SetCardInfo("Forest", 339, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 340, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 341, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 342, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forgotten Ancient", 185, Rarity.RARE, mage.cards.f.ForgottenAncient.class));
        cards.add(new SetCardInfo("Forgotten Cave", 284, Rarity.COMMON, mage.cards.f.ForgottenCave.class));
        cards.add(new SetCardInfo("Fumiko the Lowblood", 155, Rarity.RARE, mage.cards.f.FumikoTheLowblood.class));
        cards.add(new SetCardInfo("Ghostblade Eidolon", 70, Rarity.UNCOMMON, mage.cards.g.GhostbladeEidolon.class));
        cards.add(new SetCardInfo("Ghost Quarter", 285, Rarity.UNCOMMON, mage.cards.g.GhostQuarter.class));
        cards.add(new SetCardInfo("Gigantoplasm", 11, Rarity.RARE, mage.cards.g.Gigantoplasm.class));
        cards.add(new SetCardInfo("Gild", 127, Rarity.RARE, mage.cards.g.Gild.class));
        cards.add(new SetCardInfo("Gisela, Blade of Goldnight", 219, Rarity.MYTHIC, mage.cards.g.GiselaBladeOfGoldnight.class));
        cards.add(new SetCardInfo("Goblin Electromancer", 220, Rarity.COMMON, mage.cards.g.GoblinElectromancer.class));
        cards.add(new SetCardInfo("Golgari Charm", 221, Rarity.UNCOMMON, mage.cards.g.GolgariCharm.class));
        cards.add(new SetCardInfo("Golgari Guildgate", 286, Rarity.COMMON, mage.cards.g.GolgariGuildgate.class));
        cards.add(new SetCardInfo("Golgari Rot Farm", 287, Rarity.COMMON, mage.cards.g.GolgariRotFarm.class));
        cards.add(new SetCardInfo("Golgari Signet", 255, Rarity.COMMON, mage.cards.g.GolgariSignet.class));
        cards.add(new SetCardInfo("Grasp of Fate", 3, Rarity.RARE, mage.cards.g.GraspOfFate.class));
        cards.add(new SetCardInfo("Grave Peril", 128, Rarity.COMMON, mage.cards.g.GravePeril.class));
        cards.add(new SetCardInfo("Great Oak Guardian", 37, Rarity.UNCOMMON, mage.cards.g.GreatOakGuardian.class));
        cards.add(new SetCardInfo("Grim Backwoods", 288, Rarity.RARE, mage.cards.g.GrimBackwoods.class));
        cards.add(new SetCardInfo("Grisly Salvage", 222, Rarity.COMMON, mage.cards.g.GrislySalvage.class));
        cards.add(new SetCardInfo("Hamletback Goliath", 156, Rarity.RARE, mage.cards.h.HamletbackGoliath.class));
        cards.add(new SetCardInfo("Hammerfist Giant", 157, Rarity.RARE, mage.cards.h.HammerfistGiant.class));
        cards.add(new SetCardInfo("Herald of the Host", 4, Rarity.UNCOMMON, mage.cards.h.HeraldOfTheHost.class));
        cards.add(new SetCardInfo("High Market", 289, Rarity.RARE, mage.cards.h.HighMarket.class));
        cards.add(new SetCardInfo("Hostility", 158, Rarity.RARE, mage.cards.h.Hostility.class));
        cards.add(new SetCardInfo("Hunted Dragon", 159, Rarity.RARE, mage.cards.h.HuntedDragon.class));
        cards.add(new SetCardInfo("Illusory Ambusher", 12, Rarity.UNCOMMON, mage.cards.i.IllusoryAmbusher.class));
        cards.add(new SetCardInfo("Indrik Stomphowler", 186, Rarity.UNCOMMON, mage.cards.i.IndrikStomphowler.class));
        cards.add(new SetCardInfo("Inferno Titan", 160, Rarity.MYTHIC, mage.cards.i.InfernoTitan.class));
        cards.add(new SetCardInfo("Island", 327, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 328, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 329, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 330, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Izzet Boilerworks", 290, Rarity.COMMON, mage.cards.i.IzzetBoilerworks.class));
        cards.add(new SetCardInfo("Izzet Guildgate", 291, Rarity.COMMON, mage.cards.i.IzzetGuildgate.class));
        cards.add(new SetCardInfo("Izzet Signet", 256, Rarity.COMMON, mage.cards.i.IzzetSignet.class));
        cards.add(new SetCardInfo("Jace's Archivist", 95, Rarity.RARE, mage.cards.j.JacesArchivist.class));
        cards.add(new SetCardInfo("Jarad, Golgari Lich Lord", 223, Rarity.MYTHIC, mage.cards.j.JaradGolgariLichLord.class));
        cards.add(new SetCardInfo("Jareth, Leonine Titan", 71, Rarity.RARE, mage.cards.j.JarethLeonineTitan.class));
        cards.add(new SetCardInfo("Jungle Hollow", 292, Rarity.COMMON, mage.cards.j.JungleHollow.class));
        cards.add(new SetCardInfo("Kalemne, Disciple of Iroas", 45, Rarity.MYTHIC, mage.cards.k.KalemneDiscipleOfIroas.class));
        cards.add(new SetCardInfo("Kalemne's Captain", 5, Rarity.RARE, mage.cards.k.KalemnesCaptain.class));
        cards.add(new SetCardInfo("Karlov of the Ghost Council", 46, Rarity.MYTHIC, mage.cards.k.KarlovOfTheGhostCouncil.class));
        cards.add(new SetCardInfo("Karmic Justice", 72, Rarity.RARE, mage.cards.k.KarmicJustice.class));
        cards.add(new SetCardInfo("Kaseto, Orochi Archmage", 47, Rarity.MYTHIC, mage.cards.k.KasetoOrochiArchmage.class));
        cards.add(new SetCardInfo("Kessig Cagebreakers", 187, Rarity.RARE, mage.cards.k.KessigCagebreakers.class));
        cards.add(new SetCardInfo("Kodama's Reach", 188, Rarity.COMMON, mage.cards.k.KodamasReach.class));
        cards.add(new SetCardInfo("Korozda Guildmage", 224, Rarity.UNCOMMON, mage.cards.k.KorozdaGuildmage.class));
        cards.add(new SetCardInfo("Kor Sanctifiers", 73, Rarity.COMMON, mage.cards.k.KorSanctifiers.class));
        cards.add(new SetCardInfo("Krosan Grip", 189, Rarity.UNCOMMON, mage.cards.k.KrosanGrip.class));
        cards.add(new SetCardInfo("Lightning Greaves", 257, Rarity.UNCOMMON, mage.cards.l.LightningGreaves.class));
        cards.add(new SetCardInfo("Llanowar Reborn", 293, Rarity.UNCOMMON, mage.cards.l.LlanowarReborn.class));
        cards.add(new SetCardInfo("Loaming Shaman", 190, Rarity.RARE, mage.cards.l.LoamingShaman.class));
        cards.add(new SetCardInfo("Lone Revenant", 96, Rarity.RARE, mage.cards.l.LoneRevenant.class));
        cards.add(new SetCardInfo("Lorescale Coatl", 225, Rarity.UNCOMMON, mage.cards.l.LorescaleCoatl.class));
        cards.add(new SetCardInfo("Lotleth Troll", 226, Rarity.RARE, mage.cards.l.LotlethTroll.class));
        cards.add(new SetCardInfo("Loxodon Warhammer", 258, Rarity.RARE, mage.cards.l.LoxodonWarhammer.class));
        cards.add(new SetCardInfo("Magma Giant", 161, Rarity.RARE, mage.cards.m.MagmaGiant.class));
        cards.add(new SetCardInfo("Magmaquake", 162, Rarity.RARE, mage.cards.m.Magmaquake.class));
        cards.add(new SetCardInfo("Magus of the Wheel", 27, Rarity.RARE, mage.cards.m.MagusOfTheWheel.class));
        cards.add(new SetCardInfo("Marshal's Anthem", 74, Rarity.RARE, mage.cards.m.MarshalsAnthem.class));
        cards.add(new SetCardInfo("Mazirek, Kraul Death Priest", 48, Rarity.MYTHIC, mage.cards.m.MazirekKraulDeathPriest.class));
        cards.add(new SetCardInfo("Melek, Izzet Paragon", 227, Rarity.RARE, mage.cards.m.MelekIzzetParagon.class));
        cards.add(new SetCardInfo("Meren of Clan Nel Toth", 49, Rarity.MYTHIC, mage.cards.m.MerenOfClanNelToth.class));
        cards.add(new SetCardInfo("Mesa Enchantress", 75, Rarity.RARE, mage.cards.m.MesaEnchantress.class));
        cards.add(new SetCardInfo("Meteor Blast", 28, Rarity.UNCOMMON, mage.cards.m.MeteorBlast.class));
        cards.add(new SetCardInfo("Mind Stone", 259, Rarity.UNCOMMON, mage.cards.m.MindStone.class));
        cards.add(new SetCardInfo("Mirror Match", 13, Rarity.UNCOMMON, mage.cards.m.MirrorMatch.class));
        cards.add(new SetCardInfo("Mizzium Mortars", 163, Rarity.RARE, mage.cards.m.MizziumMortars.class));
        cards.add(new SetCardInfo("Mizzix of the Izmagnus", 50, Rarity.MYTHIC, mage.cards.m.MizzixOfTheIzmagnus.class));
        cards.add(new SetCardInfo("Mizzix's Mastery", 29, Rarity.RARE, mage.cards.m.MizzixsMastery.class));
        cards.add(new SetCardInfo("Monk Idealist", 76, Rarity.UNCOMMON, mage.cards.m.MonkIdealist.class));
        cards.add(new SetCardInfo("Mosswort Bridge", 294, Rarity.RARE, mage.cards.m.MosswortBridge.class));
        cards.add(new SetCardInfo("Mountain", 335, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 336, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 337, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 338, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mulch", 191, Rarity.COMMON, mage.cards.m.Mulch.class));
        cards.add(new SetCardInfo("Mulldrifter", 97, Rarity.UNCOMMON, mage.cards.m.Mulldrifter.class));
        cards.add(new SetCardInfo("Mycoloth", 192, Rarity.RARE, mage.cards.m.Mycoloth.class));
        cards.add(new SetCardInfo("Mystic Confluence", 14, Rarity.RARE, mage.cards.m.MysticConfluence.class));
        cards.add(new SetCardInfo("Mystic Retrieval", 98, Rarity.UNCOMMON, mage.cards.m.MysticRetrieval.class));
        cards.add(new SetCardInfo("Mystic Snake", 228, Rarity.RARE, mage.cards.m.MysticSnake.class));
        cards.add(new SetCardInfo("Necromancer's Covenant", 229, Rarity.RARE, mage.cards.n.NecromancersCovenant.class));
        cards.add(new SetCardInfo("New Benalia", 295, Rarity.UNCOMMON, mage.cards.n.NewBenalia.class));
        cards.add(new SetCardInfo("Nighthowler", 129, Rarity.RARE, mage.cards.n.Nighthowler.class));
        cards.add(new SetCardInfo("Ninja of the Deep Hours", 99, Rarity.COMMON, mage.cards.n.NinjaOfTheDeepHours.class));
        cards.add(new SetCardInfo("Noble Quarry", 193, Rarity.UNCOMMON, mage.cards.n.NobleQuarry.class));
        cards.add(new SetCardInfo("Novijen, Heart of Progress", 296, Rarity.UNCOMMON, mage.cards.n.NovijenHeartOfProgress.class));
        cards.add(new SetCardInfo("Ohran Viper", 194, Rarity.RARE, mage.cards.o.OhranViper.class));
        cards.add(new SetCardInfo("Open the Vaults", 77, Rarity.RARE, mage.cards.o.OpenTheVaults.class));
        cards.add(new SetCardInfo("Oran-Rief, the Vastwood", 297, Rarity.RARE, mage.cards.o.OranRiefTheVastwood.class));
        cards.add(new SetCardInfo("Oreskos Explorer", 6, Rarity.UNCOMMON, mage.cards.o.OreskosExplorer.class));
        cards.add(new SetCardInfo("Orim's Thunder", 78, Rarity.COMMON, mage.cards.o.OrimsThunder.class));
        cards.add(new SetCardInfo("Orochi Hatchery", 260, Rarity.RARE, mage.cards.o.OrochiHatchery.class));
        cards.add(new SetCardInfo("Orzhov Basilica", 298, Rarity.COMMON, mage.cards.o.OrzhovBasilica.class));
        cards.add(new SetCardInfo("Orzhov Cluestone", 261, Rarity.COMMON, mage.cards.o.OrzhovCluestone.class));
        cards.add(new SetCardInfo("Orzhov Guildgate", 299, Rarity.COMMON, mage.cards.o.OrzhovGuildgate.class));
        cards.add(new SetCardInfo("Orzhov Signet", 262, Rarity.COMMON, mage.cards.o.OrzhovSignet.class));
        cards.add(new SetCardInfo("Overrun", 195, Rarity.UNCOMMON, mage.cards.o.Overrun.class));
        cards.add(new SetCardInfo("Overwhelming Stampede", 196, Rarity.RARE, mage.cards.o.OverwhelmingStampede.class));
        cards.add(new SetCardInfo("Patagia Viper", 197, Rarity.UNCOMMON, mage.cards.p.PatagiaViper.class));
        cards.add(new SetCardInfo("Pathbreaker Ibex", 38, Rarity.RARE, mage.cards.p.PathbreakerIbex.class));
        cards.add(new SetCardInfo("Phyrexian Arena", 130, Rarity.RARE, mage.cards.p.PhyrexianArena.class));
        cards.add(new SetCardInfo("Phyrexian Plaguelord", 131, Rarity.RARE, mage.cards.p.PhyrexianPlaguelord.class));
        cards.add(new SetCardInfo("Phyrexian Rager", 132, Rarity.COMMON, mage.cards.p.PhyrexianRager.class));
        cards.add(new SetCardInfo("Phyrexian Reclamation", 133, Rarity.UNCOMMON, mage.cards.p.PhyrexianReclamation.class));
        cards.add(new SetCardInfo("Plains", 323, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 324, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 325, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 326, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plaxmanta", 100, Rarity.UNCOMMON, mage.cards.p.Plaxmanta.class));
        cards.add(new SetCardInfo("Polluted Mire", 300, Rarity.COMMON, mage.cards.p.PollutedMire.class));
        cards.add(new SetCardInfo("Preordain", 101, Rarity.COMMON, mage.cards.p.Preordain.class));
        cards.add(new SetCardInfo("Primal Growth", 198, Rarity.COMMON, mage.cards.p.PrimalGrowth.class));
        cards.add(new SetCardInfo("Prime Speaker Zegana", 230, Rarity.MYTHIC, mage.cards.p.PrimeSpeakerZegana.class));
        cards.add(new SetCardInfo("Prophetic Bolt", 231, Rarity.RARE, mage.cards.p.PropheticBolt.class));
        cards.add(new SetCardInfo("Psychosis Crawler", 263, Rarity.RARE, mage.cards.p.PsychosisCrawler.class));
        cards.add(new SetCardInfo("Putrefy", 232, Rarity.UNCOMMON, mage.cards.p.Putrefy.class));
        cards.add(new SetCardInfo("Rampant Growth", 199, Rarity.COMMON, mage.cards.r.RampantGrowth.class));
        cards.add(new SetCardInfo("Rapid Hybridization", 102, Rarity.UNCOMMON, mage.cards.r.RapidHybridization.class));
        cards.add(new SetCardInfo("Reins of Power", 103, Rarity.RARE, mage.cards.r.ReinsOfPower.class));
        cards.add(new SetCardInfo("Reliquary Tower", 301, Rarity.UNCOMMON, mage.cards.r.ReliquaryTower.class));
        cards.add(new SetCardInfo("Repeal", 104, Rarity.COMMON, mage.cards.r.Repeal.class));
        cards.add(new SetCardInfo("Righteous Confluence", 7, Rarity.RARE, mage.cards.r.RighteousConfluence.class));
        cards.add(new SetCardInfo("Rise from the Grave", 134, Rarity.UNCOMMON, mage.cards.r.RiseFromTheGrave.class));
        cards.add(new SetCardInfo("Rite of Replication", 105, Rarity.RARE, mage.cards.r.RiteOfReplication.class));
        cards.add(new SetCardInfo("Rite of the Raging Storm", 30, Rarity.UNCOMMON, mage.cards.r.RiteOfTheRagingStorm.class));
        cards.add(new SetCardInfo("Rogue's Passage", 302, Rarity.UNCOMMON, mage.cards.r.RoguesPassage.class));
        cards.add(new SetCardInfo("Sakura-Tribe Elder", 200, Rarity.COMMON, mage.cards.s.SakuraTribeElder.class));
        cards.add(new SetCardInfo("Sandstone Oracle", 52, Rarity.UNCOMMON, mage.cards.s.SandstoneOracle.class));
        cards.add(new SetCardInfo("Satyr Wayfinder", 201, Rarity.COMMON, mage.cards.s.SatyrWayfinder.class));
        cards.add(new SetCardInfo("Scoured Barrens", 303, Rarity.COMMON, mage.cards.s.ScouredBarrens.class));
        cards.add(new SetCardInfo("Scourge of Nel Toth", 21, Rarity.RARE, mage.cards.s.ScourgeOfNelToth.class));
        cards.add(new SetCardInfo("Scytheclaw", 53, Rarity.RARE, mage.cards.s.Scytheclaw.class));
        cards.add(new SetCardInfo("Seal of Cleansing", 79, Rarity.COMMON, mage.cards.s.SealOfCleansing.class));
        cards.add(new SetCardInfo("Seal of Doom", 135, Rarity.COMMON, mage.cards.s.SealOfDoom.class));
        cards.add(new SetCardInfo("Seal of the Guildpact", 54, Rarity.RARE, mage.cards.s.SealOfTheGuildpact.class));
        cards.add(new SetCardInfo("Secluded Steppe", 304, Rarity.COMMON, mage.cards.s.SecludedSteppe.class));
        cards.add(new SetCardInfo("Seer's Sundial", 264, Rarity.RARE, mage.cards.s.SeersSundial.class));
        cards.add(new SetCardInfo("Sever the Bloodline", 136, Rarity.RARE, mage.cards.s.SeverTheBloodline.class));
        cards.add(new SetCardInfo("Shielded by Faith", 8, Rarity.RARE, mage.cards.s.ShieldedByFaith.class));
        cards.add(new SetCardInfo("Shriekmaw", 137, Rarity.UNCOMMON, mage.cards.s.Shriekmaw.class));
        cards.add(new SetCardInfo("Sigil of the Empty Throne", 80, Rarity.RARE, mage.cards.s.SigilOfTheEmptyThrone.class));
        cards.add(new SetCardInfo("Silent Sentinel", 81, Rarity.RARE, mage.cards.s.SilentSentinel.class));
        cards.add(new SetCardInfo("Simic Growth Chamber", 305, Rarity.COMMON, mage.cards.s.SimicGrowthChamber.class));
        cards.add(new SetCardInfo("Simic Guildgate", 306, Rarity.COMMON, mage.cards.s.SimicGuildgate.class));
        cards.add(new SetCardInfo("Simic Keyrune", 265, Rarity.UNCOMMON, mage.cards.s.SimicKeyrune.class));
        cards.add(new SetCardInfo("Simic Signet", 266, Rarity.COMMON, mage.cards.s.SimicSignet.class));
        cards.add(new SetCardInfo("Skullclamp", 267, Rarity.UNCOMMON, mage.cards.s.Skullclamp.class));
        cards.add(new SetCardInfo("Skullwinder", 39, Rarity.UNCOMMON, mage.cards.s.Skullwinder.class));
        cards.add(new SetCardInfo("Sleep", 106, Rarity.UNCOMMON, mage.cards.s.Sleep.class));
        cards.add(new SetCardInfo("Slippery Karst", 307, Rarity.COMMON, mage.cards.s.SlipperyKarst.class));
        cards.add(new SetCardInfo("Smoldering Crater", 308, Rarity.COMMON, mage.cards.s.SmolderingCrater.class));
        cards.add(new SetCardInfo("Snakeform", 242, Rarity.COMMON, mage.cards.s.Snakeform.class));
        cards.add(new SetCardInfo("Solemn Simulacrum", 269, Rarity.RARE, mage.cards.s.SolemnSimulacrum.class));
        cards.add(new SetCardInfo("Sol Ring", 268, Rarity.UNCOMMON, mage.cards.s.SolRing.class));
        cards.add(new SetCardInfo("Spider Spawning", 202, Rarity.UNCOMMON, mage.cards.s.SpiderSpawning.class));
        cards.add(new SetCardInfo("Spinerock Knoll", 309, Rarity.RARE, mage.cards.s.SpinerockKnoll.class));
        cards.add(new SetCardInfo("Staff of Nin", 270, Rarity.RARE, mage.cards.s.StaffOfNin.class));
        cards.add(new SetCardInfo("Steam Augury", 233, Rarity.RARE, mage.cards.s.SteamAugury.class));
        cards.add(new SetCardInfo("Stingerfling Spider", 203, Rarity.UNCOMMON, mage.cards.s.StingerflingSpider.class));
        cards.add(new SetCardInfo("Stinkdrinker Daredevil", 164, Rarity.COMMON, mage.cards.s.StinkdrinkerDaredevil.class));
        cards.add(new SetCardInfo("Stolen Goods", 107, Rarity.RARE, mage.cards.s.StolenGoods.class));
        cards.add(new SetCardInfo("Stoneshock Giant", 165, Rarity.UNCOMMON, mage.cards.s.StoneshockGiant.class));
        cards.add(new SetCardInfo("Stroke of Genius", 108, Rarity.RARE, mage.cards.s.StrokeOfGenius.class));
        cards.add(new SetCardInfo("Sunrise Sovereign", 166, Rarity.RARE, mage.cards.s.SunriseSovereign.class));
        cards.add(new SetCardInfo("Sun Titan", 82, Rarity.MYTHIC, mage.cards.s.SunTitan.class));
        cards.add(new SetCardInfo("Swamp", 331, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 332, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 333, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 334, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swiftfoot Boots", 271, Rarity.UNCOMMON, mage.cards.s.SwiftfootBoots.class));
        cards.add(new SetCardInfo("Swiftwater Cliffs", 310, Rarity.COMMON, mage.cards.s.SwiftwaterCliffs.class));
        cards.add(new SetCardInfo("Sword of Vengeance", 272, Rarity.RARE, mage.cards.s.SwordOfVengeance.class));
        cards.add(new SetCardInfo("Synthetic Destiny", 15, Rarity.RARE, mage.cards.s.SyntheticDestiny.class));
        cards.add(new SetCardInfo("Tainted Field", 311, Rarity.UNCOMMON, mage.cards.t.TaintedField.class));
        cards.add(new SetCardInfo("Tainted Wood", 312, Rarity.UNCOMMON, mage.cards.t.TaintedWood.class));
        cards.add(new SetCardInfo("Talrand, Sky Summoner", 109, Rarity.RARE, mage.cards.t.TalrandSkySummoner.class));
        cards.add(new SetCardInfo("Taurean Mauler", 167, Rarity.RARE, mage.cards.t.TaureanMauler.class));
        cards.add(new SetCardInfo("Temple of the False God", 313, Rarity.UNCOMMON, mage.cards.t.TempleOfTheFalseGod.class));
        cards.add(new SetCardInfo("Terastodon", 204, Rarity.RARE, mage.cards.t.Terastodon.class));
        cards.add(new SetCardInfo("Terramorphic Expanse", 314, Rarity.COMMON, mage.cards.t.TerramorphicExpanse.class));
        cards.add(new SetCardInfo("Teysa, Envoy of Ghosts", 234, Rarity.RARE, mage.cards.t.TeysaEnvoyOfGhosts.class));
        cards.add(new SetCardInfo("Thelonite Hermit", 205, Rarity.RARE, mage.cards.t.TheloniteHermit.class));
        cards.add(new SetCardInfo("Thief of Blood", 22, Rarity.UNCOMMON, mage.cards.t.ThiefOfBlood.class));
        cards.add(new SetCardInfo("Thornwood Falls", 315, Rarity.COMMON, mage.cards.t.ThornwoodFalls.class));
        cards.add(new SetCardInfo("Thought Reflection", 110, Rarity.RARE, mage.cards.t.ThoughtReflection.class));
        cards.add(new SetCardInfo("Thought Vessel", 55, Rarity.COMMON, mage.cards.t.ThoughtVessel.class));
        cards.add(new SetCardInfo("Thundercloud Shaman", 168, Rarity.UNCOMMON, mage.cards.t.ThundercloudShaman.class));
        cards.add(new SetCardInfo("Treasury Thrull", 235, Rarity.RARE, mage.cards.t.TreasuryThrull.class));
        cards.add(new SetCardInfo("Tribute to the Wild", 206, Rarity.UNCOMMON, mage.cards.t.TributeToTheWild.class));
        cards.add(new SetCardInfo("Trygon Predator", 236, Rarity.UNCOMMON, mage.cards.t.TrygonPredator.class));
        cards.add(new SetCardInfo("Underworld Coinsmith", 237, Rarity.UNCOMMON, mage.cards.u.UnderworldCoinsmith.class));
        cards.add(new SetCardInfo("Underworld Connections", 138, Rarity.RARE, mage.cards.u.UnderworldConnections.class));
        cards.add(new SetCardInfo("Urza's Incubator", 273, Rarity.RARE, mage.cards.u.UrzasIncubator.class));
        cards.add(new SetCardInfo("Urza's Rage", 169, Rarity.RARE, mage.cards.u.UrzasRage.class));
        cards.add(new SetCardInfo("Vandalblast", 170, Rarity.UNCOMMON, mage.cards.v.Vandalblast.class));
        cards.add(new SetCardInfo("Verdant Confluence", 40, Rarity.RARE, mage.cards.v.VerdantConfluence.class));
        cards.add(new SetCardInfo("Verdant Force", 207, Rarity.RARE, mage.cards.v.VerdantForce.class));
        cards.add(new SetCardInfo("Victimize", 139, Rarity.UNCOMMON, mage.cards.v.Victimize.class));
        cards.add(new SetCardInfo("Victory's Herald", 83, Rarity.RARE, mage.cards.v.VictorysHerald.class));
        cards.add(new SetCardInfo("Viridian Emissary", 208, Rarity.COMMON, mage.cards.v.ViridianEmissary.class));
        cards.add(new SetCardInfo("Viridian Shaman", 209, Rarity.UNCOMMON, mage.cards.v.ViridianShaman.class));
        cards.add(new SetCardInfo("Viridian Zealot", 210, Rarity.RARE, mage.cards.v.ViridianZealot.class));
        cards.add(new SetCardInfo("Vivid Crag", 316, Rarity.UNCOMMON, mage.cards.v.VividCrag.class));
        cards.add(new SetCardInfo("Vivid Creek", 317, Rarity.UNCOMMON, mage.cards.v.VividCreek.class));
        cards.add(new SetCardInfo("Vivid Grove", 318, Rarity.UNCOMMON, mage.cards.v.VividGrove.class));
        cards.add(new SetCardInfo("Vivid Marsh", 319, Rarity.UNCOMMON, mage.cards.v.VividMarsh.class));
        cards.add(new SetCardInfo("Vivid Meadow", 320, Rarity.UNCOMMON, mage.cards.v.VividMeadow.class));
        cards.add(new SetCardInfo("Vow of Duty", 84, Rarity.UNCOMMON, mage.cards.v.VowOfDuty.class));
        cards.add(new SetCardInfo("Vow of Malice", 140, Rarity.UNCOMMON, mage.cards.v.VowOfMalice.class));
        cards.add(new SetCardInfo("Vulturous Zombie", 238, Rarity.RARE, mage.cards.v.VulturousZombie.class));
        cards.add(new SetCardInfo("Wall of Blossoms", 211, Rarity.UNCOMMON, mage.cards.w.WallOfBlossoms.class));
        cards.add(new SetCardInfo("Warchief Giant", 31, Rarity.UNCOMMON, mage.cards.w.WarchiefGiant.class));
        cards.add(new SetCardInfo("Warstorm Surge", 171, Rarity.RARE, mage.cards.w.WarstormSurge.class));
        cards.add(new SetCardInfo("Wayfarer's Bauble", 274, Rarity.COMMON, mage.cards.w.WayfarersBauble.class));
        cards.add(new SetCardInfo("Windfall", 111, Rarity.UNCOMMON, mage.cards.w.Windfall.class));
        cards.add(new SetCardInfo("Wind-Scarred Crag", 321, Rarity.COMMON, mage.cards.w.WindScarredCrag.class));
        cards.add(new SetCardInfo("Wistful Selkie", 243, Rarity.UNCOMMON, mage.cards.w.WistfulSelkie.class));
        cards.add(new SetCardInfo("Wood Elves", 212, Rarity.COMMON, mage.cards.w.WoodElves.class));
        cards.add(new SetCardInfo("Word of Seizing", 172, Rarity.RARE, mage.cards.w.WordOfSeizing.class));
        cards.add(new SetCardInfo("Worn Powerstone", 275, Rarity.UNCOMMON, mage.cards.w.WornPowerstone.class));
        cards.add(new SetCardInfo("Wretched Confluence", 23, Rarity.RARE, mage.cards.w.WretchedConfluence.class));
        cards.add(new SetCardInfo("Zoetic Cavern", 322, Rarity.UNCOMMON, mage.cards.z.ZoeticCavern.class));
    }

}
