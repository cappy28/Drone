# DroneXP 🚁

Application gamifiée qui transforme les bonnes actions scolaires en pièces de drone réelles.

---

## 🚀 Démarrage rapide (15 minutes)

### 1. Crée un repo GitHub
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/TON-USERNAME/dronexp.git
git push -u origin main
```

### 2. Configure Firebase (pour la sync parents ↔ enfant)

1. Va sur [console.firebase.google.com](https://console.firebase.google.com)
2. **Créer un projet** → donne un nom → désactive Google Analytics
3. **Ajouter une app Web** (icône `</>`) → enregistre
4. Copie la configuration dans **deux fichiers** :
   - `android/app/src/main/assets/www/firebase-config.js`
   - `parent-web/firebase-config.js`
5. Dans Firebase → **Realtime Database** → Créer une base → Mode test → Terminé

```js
// firebase-config.js
const FIREBASE_CONFIG = {
  apiKey: "...",           // ← Remplace par tes vraies valeurs
  authDomain: "...",
  databaseURL: "https://...-default-rtdb.europe-west1.firebasedatabase.app",
  ...
};
```

6. `git add . && git commit -m "Add Firebase config" && git push`

### 3. Télécharge l'APK

1. Va sur ton repo GitHub → onglet **Actions**
2. Attends que le build soit terminé (≈ 5 min)
3. Clique sur le workflow → **Artifacts** → `DroneXP-debug-APK`
4. Installe l'APK sur le téléphone de ton enfant

⚠️ Pour installer l'APK : **Paramètres → Sécurité → Sources inconnues** → activer

### 4. Site parents

Après le premier push, le site parents est automatiquement déployé sur :
```
https://TON-USERNAME.github.io/dronexp/
```

**Premier accès** : le site demande de configurer le PIN et le code famille.
- PIN par défaut au départ : à créer lors du premier accès
- Entre le même **code famille** que dans l'app enfant

---

## 📱 Fonctionnement

### App enfant (APK)
| Action | XP |
|--------|-----|
| Pas de mot dans le carnet (vendredi) | +50 XP |
| Note ≥ 15/20 | +60 XP |
| Journée sans écran | +5 XP |
| Pénalité parent | −10 XP |

### Boutique drone (125 XP par pièce)
- Moteurs brushless ×4
- Châssis carbone
- ESC + Flight Controller
- Hélices 5"
- Batterie LiPo 6S
- Récepteur ELRS
- Module GPS
- Chargeur batterie
- 🎮 Radiomaster Pocket (26 avril 2026)
- 🥽 DJI Goggles N3 (11 juin 2026)
- 📷 DJI Air Unit O4 Pro (11 juin 2026)

### Interface parents
- PIN sécurisé (à configurer au premier accès)
- Valider / refuser les déclarations de l'enfant
- Ajouter des pénalités
- Voir l'historique XP

---

## 🔧 Structure du projet

```
dronexp/
├── android/                    # Projet Android (WebView)
│   └── app/src/main/
│       └── assets/www/
│           ├── index.html      # App enfant
│           └── firebase-config.js
├── parent-web/
│   ├── index.html              # Dashboard parents
│   └── firebase-config.js
├── .github/workflows/
│   └── build-apk.yml          # Build automatique
└── README.md
```

---

## ❓ FAQ

**L'app fonctionne sans Firebase ?**
Oui, en mode local (données dans le téléphone). Mais sans Firebase, les parents ne voient pas les actions de l'enfant en temps réel.

**Comment changer le PIN parent ?**
Supprime le localStorage du navigateur sur le site parents (`F12` → Application → Storage → Clear) et recommence la configuration.

**Le build APK échoue ?**
Vérifie que le repo est bien configuré : onglet **Settings → Actions → General → Workflow permissions → Read and write**.

**Comment mettre à jour l'app ?**
Modifie `android/app/src/main/assets/www/index.html`, push sur GitHub, télécharge le nouvel APK dans Actions.
